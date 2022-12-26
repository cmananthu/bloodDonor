package com.project.bloodDonor.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

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
	private String donorName;
	private String phone;
	private String email;
	private String bloodGroup;
	private String gender;
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
