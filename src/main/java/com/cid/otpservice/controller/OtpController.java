package com.cid.otpservice.controller;

import com.cid.otpservice.service.OtpService;
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

    @GetMapping("/test")
    public ResponseEntity<String> testOtp() {
        logger.info("In the controller");
        return ResponseEntity.ok("Controller done ");
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendOtp(@RequestParam String email) {
        logger.info("Sending OTP to email: {}", email);
        otpService.sendOtp(email);
        return ResponseEntity.ok("OTP sent to email: " + email);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        boolean isVerified = otpService.verifyOtp(email, otp);
        if (isVerified) {
            return ResponseEntity.ok("OTP verified successfully!");
        } else {
            return ResponseEntity.status(400).body("Invalid or expired OTP.");
        }
    }
}
