package com.axiom.mobile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.axiom.mobile.dto"})
public class HandsetSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsetSearchApplication.class, args);
	}

}
