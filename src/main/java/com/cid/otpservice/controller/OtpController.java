package com.cid.otpservice.controller;

import com.cid.otpservice.service.OtpService;
import com.cid.otpservice.model.Otp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/otp")
public class OtpController {

    private static final Logger logger = LoggerFactory.getLogger(OtpController.class);

    @Autowired
    private OtpService otpService;

    @PostMapping("/generate")
    public ResponseEntity<String> generateOtp(@RequestParam String recipient, @RequestParam Otp.OtpChannel channel) {
        String otp = otpService.generateOtp(recipient, channel);
        return ResponseEntity.ok("OTP sent to " + recipient + " via " + channel);
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateOtp(@RequestParam String recipient, @RequestParam String otp) {
        boolean isValid = otpService.validateOtp(recipient, otp);
        if (isValid) {
            return ResponseEntity.ok("OTP is valid");
        } else {
            return ResponseEntity.badRequest().body("Invalid OTP");
        }
    }
}
