package com.project.bloodDonor.entity;

public class BloodDonorDAO {
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
	@Override
	public String toString() {
		return "BloodDonorDAO [id=" + id + ", donorName=" + donorName + ", phone=" + phone + ", email=" + email
				+ ", bloodGroup=" + bloodGroup + ", gender=" + gender + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", bmi=" + bmi + ", state=" + state + ", city=" + city + ", pincode=" + pincode
				+ ", isReadytoDonate=" + isReadytoDonate + "]";
	}
	public BloodDonorDAO(int id, String donorName, String phone, String email, String bloodGroup, String gender,
			String age, double height, double weight, double bmi, String state, String city, String pincode,
			boolean isReadytoDonate) {
		super();
		this.id = id;
		this.donorName = donorName;
		this.phone = phone;
		this.email = email;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.isReadytoDonate = isReadytoDonate;
	}
	public BloodDonorDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
