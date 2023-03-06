package com.project.bloodDonor.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
	@NotBlank(message = "Name is mandatory")
	private String donorName;
	private String phone;
	@Email(message="email should be valid")
	@NotBlank(message = "Email is mandatory")
	private String email;
	@NotNull(message="add a blood group")
	private String bloodGroup;
	private String gender;
	@Min(value=18,message="age should be greater than 18")
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public boolean isReadytoDonate() {
		return isReadytoDonate;
	}
	public void setReadytoDonate(boolean isReadytoDonate) {
		this.isReadytoDonate = isReadytoDonate;
	}
	public String getMartialStatus() {
		return martialStatus;
	}
	
	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}
	
	
}
