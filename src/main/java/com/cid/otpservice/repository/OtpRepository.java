package com.cid.otpservice.repository;

import com.cid.otpservice.model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Long> {
    Otp findByRecipientAndOtp(String recipient, String otp);
}
