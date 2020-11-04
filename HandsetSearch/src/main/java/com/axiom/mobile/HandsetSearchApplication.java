package com.axiom.mobile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.axiom.mobile.dto.Handset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.axiom.mobile.service.HandsetService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
@EntityScan(basePackages = {"com.axiom.mobile.dto"})
public class HandsetSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandsetSearchApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(HandsetService handsetService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Handset>> typeReference = new TypeReference<List<Handset>>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Mobiledatabase.json");
			try {
				List<Handset> handsets = mapper.readValue(inputStream,typeReference);
				handsetService.save(handsets);
				System.out.println("Users Saved!");
			} catch (IOException e){
				System.out.println("Unable to save users: " + e.getMessage());
			}
		};
	}

}
