package com.cid.otpservice.service;

import org.springframework.beans.factory.annotation.Value;

import com.cid.otpservice.model.Otp;
import com.cid.otpservice.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import jakarta.mail.internet.MimeMessage.RecipientType;

import com.mailersend.sdk.emails.Email;
import com.mailersend.sdk.MailerSend;
import com.mailersend.sdk.MailerSendResponse;
import com.mailersend.sdk.exceptions.MailerSendException;

//import jakarta.mail.internet.MimeMessageHelper;
import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    private static final Logger logger = LoggerFactory.getLogger(OtpService.class);

    @Value("${spring.mail.username}")
    private String mailUsername;

    @Value("${spring.mail.password}")
    private String mailPassword;

    @Autowired
    private OtpRepository otpRepository;

    private static final int EXPIRATION_MINUTES = 5;

    public String generateOtp() {
        return String.valueOf(new Random().nextInt(900000) + 100000); // Generates a 6-digit OTP
    }

    public void sendOtp(String email) {
        String otp = generateOtp();
        Otp otpEntity = new Otp();
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpEntity.setCreatedAt(LocalDateTime.now());
        otpEntity.setExpiresAt(LocalDateTime.now().plusMinutes(EXPIRATION_MINUTES));
        otpEntity.setVerified(false);
        otpRepository.save(otpEntity);

        sendEmail(email, otp);
    }

    public void sendEmail(String to, String otp) {

        /*
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setTo(to);
            messageHelper.setSubject("Your OTP Code");
            messageHelper.setText("Your OTP is: " + otp, false); // Set false to disable HTML formatting if you want plain text
            logger.info("Sending OTP {} to {}", otp, to);
            logger.info("Mail Username: {}", mailUsername);
            // Note: Password should ideally not be logged
            logger.info("Mail Password: {}", mailPassword);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace(); // Handle exception properly
            // You might want to log this exception and handle it appropriately
        }
        */

        Email email = new Email();

        email.setFrom("name", "from");
        email.addRecipient("name", to);
        
        email.setSubject("Your OTP Code");

        email.setPlain("Your OTP is: " + otp);
        email.setHtml("<p>Your OTP is: </p>" + otp);

        MailerSend ms = new MailerSend();

        ms.setToken("token");

        try {
        
            MailerSendResponse response = ms.emails().send(email);
            logger.info("Mail response messageId: {}", response.messageId);
        } catch (MailerSendException e) {

            e.printStackTrace();
        }
    }

    public boolean verifyOtp(String email, String otp) {
        Optional<Otp> otpEntityOptional = otpRepository.findByEmailAndOtp(email, otp);
        if (otpEntityOptional.isPresent()) {
            Otp otpEntity = otpEntityOptional.get();
            if (otpEntity.getExpiresAt().isAfter(LocalDateTime.now()) && !otpEntity.isVerified()) {
                otpEntity.setVerified(true);
                otpRepository.save(otpEntity);
                return true;
            }
        }
        return false;
    }
}
