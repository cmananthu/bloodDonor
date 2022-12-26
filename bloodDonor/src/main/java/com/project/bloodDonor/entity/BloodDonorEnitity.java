package com.project.bloodDonor.entity;



import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="blood_donor_details")
public class BloodDonorEnitity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
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
	private String pincode;
	private boolean isReadytoDonate;
	private String martialStatus;
	
	
	@Override
	public String toString() {
		return "BloodDonorEnitity [id=" + id + ", donorName=" + donorName + ", phone=" + phone + ", email=" + email
				+ ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", bmi=" + bmi + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", isReadytoDonate=" + isReadytoDonate + "]";
	}
	
	
}
