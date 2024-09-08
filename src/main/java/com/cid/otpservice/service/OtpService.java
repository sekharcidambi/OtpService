package com.cid.otpservice.service;

import com.cid.otpservice.model.Otp;
import com.cid.otpservice.repository.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Value("${twilio.account.sid}")
    private String ACCOUNT_SID;

    @Value("${twilio.auth.token}")
    private String AUTH_TOKEN;

    @Value("${twilio.phone.number}")
    private String TWILIO_PHONE_NUMBER;

    private static final int OTP_LENGTH = 6;
    private static final int OTP_VALID_DURATION = 5; // minutes

    public String generateOtp(String recipient, Otp.OtpChannel channel) {
        String otp = generateRandomOtp();
        LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(OTP_VALID_DURATION);

        Otp otpEntity = new Otp();
        otpEntity.setRecipient(recipient);
        otpEntity.setOtp(otp);
        otpEntity.setExpirationTime(expirationTime);
        otpEntity.setChannel(channel);

        otpRepository.save(otpEntity);

        sendOtp(recipient, otp, channel);

        return otp;
    }

    public boolean validateOtp(String recipient, String otp) {
        Otp otpEntity = otpRepository.findByRecipientAndOtp(recipient, otp);
        if (otpEntity != null && LocalDateTime.now().isBefore(otpEntity.getExpirationTime())) {
            return true;
        }
        return false;
    }

    private String generateRandomOtp() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < OTP_LENGTH; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    private void sendOtp(String recipient, String otp, Otp.OtpChannel channel) {
        switch (channel) {
            case EMAIL:
                sendOtpEmail(recipient, otp);
                break;
            case SMS:
                sendOtpSms(recipient, otp);
                break;
        }
    }

    private void sendOtpEmail(String email, String otp) {
        // Implement email sending logic here
        System.out.println("Sending OTP " + otp + " via email to " + email);
    }

    private void sendOtpSms(String phoneNumber, String otp) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
                "Your OTP is: " + otp)
            .create();
        System.out.println("SMS sent with SID: " + message.getSid());
    }
}
