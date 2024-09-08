package com.cid.otpservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.cid.otpservice.model")
@EnableJpaRepositories("com.cid.otpservice.repository")
@ComponentScan(basePackages = {"com.cid.otpservice.service", "com.cid.otpservice.controller", "com.cid.otpservice.config"})
public class OtpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtpServiceApplication.class, args);
	}

}
