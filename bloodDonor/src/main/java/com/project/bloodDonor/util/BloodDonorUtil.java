package com.project.bloodDonor.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;

public class BloodDonorUtil {
	
	
	//convert fe dao to be entity
	 public static BloodDonorEnitity createBloodDonorEntity(BloodDonorDAO dao) {
		 BloodDonorEnitity entity=new BloodDonorEnitity();
		 entity.setId(dao.getId());
		 entity.setDonorName(dao.getDonorName());
		 entity.setEmail(dao.getEmail());
		 entity.setPhone(dao.getPhone());
		 entity.setAge(dao.getAge());
		 entity.setGender(dao.getGender());
		 entity.setBloodGroup(dao.getBloodGroup());
		 entity.setHeight(dao.getHeight());
		 entity.setWeight(dao.getWeight());
		 entity.setBmi(calculateBmi(dao));
		 entity.setState(dao.getState());
		 entity.setCity(dao.getCity());
		 entity.setPincode(dao.getPincode());
		 entity.setReadytoDonate(dao.isReadytoDonate());
		 entity.setMartialStatus(dao.getMartialStatus());
		return entity;
	 }
	 //convert be entity to fe dao
	 public static BloodDonorDAO createBloodDonorDAO(BloodDonorEnitity entity) {
		 BloodDonorDAO dao=new BloodDonorDAO();
		 dao.setId(entity.getId());
		 dao.setDonorName(entity.getDonorName());
		 dao.setEmail(entity.getEmail());
		 dao.setPhone(entity.getPhone());
		 dao.setAge(entity.getAge());
		 dao.setGender(entity.getGender());
		 dao.setBloodGroup(entity.getBloodGroup());
		 dao.setHeight(entity.getHeight());
		 dao.setWeight(entity.getWeight());
		 dao.setBmi(entity.getBmi());
		 dao.setState(entity.getState());
		 dao.setCity(entity.getCity());
		 dao.setPincode(entity.getPincode());
		 dao.setReadytoDonate(entity.isReadytoDonate());
		 dao.setMartialStatus(entity.getMartialStatus());
		return dao;
	 }
	 //list of dao
	 public static List<BloodDonorDAO> createListofBloodDonorDAO(List<BloodDonorEnitity> entity){
		 List<BloodDonorDAO> dao=new ArrayList<>();
		 for(BloodDonorEnitity e:entity) {
			 dao.add(createBloodDonorDAO(e));
		 }
		return dao;
	 }
	 //method to calculate bmi, bmi=weight/height square
	 private static double calculateBmi(BloodDonorDAO dao) {
		 double height=dao.getHeight()/100;
		 double bmi=dao.getWeight()/(height*height);
		return bmi;
	 }
}
