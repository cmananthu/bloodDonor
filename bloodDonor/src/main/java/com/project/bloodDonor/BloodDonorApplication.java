package com.project.bloodDonor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Blood Donor API Documentation",description="Blood Donor API manages the details of all the donors registered in the database. It basically do the CRUD operations.", version = "1.6.4"))

public class BloodDonorApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BloodDonorApplication.class, args);
	}

	
}
