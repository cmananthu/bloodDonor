package com.project.bloodDonor.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonorDAO {

	private int id;
	@JsonProperty("name")
	@NotBlank(message = "Name is mandatory")
	// for open API
	@Schema(description = "The donor's name")
	private String donorName;
	@Schema(description = "Valid phone number")
	private String phone;
	@Email(message = "email should be valid")
	@NotBlank(message = "Email is mandatory")
	@Schema(description = "Email should be valid and is mandatory")
	private String email;
	@NotNull(message = "add a blood group")
	@Schema(description = "Blood group should not be null")
	private String bloodGroup;
	private String gender;
	@Schema(description = "age should be greater than 18")
	@Min(value = 18, message = "age should be greater than 18")
	private String age;
	private double height;
	private double weight;
	private double bmi;
	private String state;
	private String city;
	@JsonProperty("pin")
	private String pincode;
	@JsonProperty("readytoDonate")
	private boolean isReadytoDonate;
	@JsonProperty("martial_status")
	private String martialStatus;

	
}
