package com.project.bloodDonor.service;

import java.util.List;

import com.project.bloodDonor.custom.exceptions.UserAlreadyDeletedException;
import com.project.bloodDonor.custom.exceptions.UserNotFoundException;
import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;

public interface BloodDonorService {
	
	 BloodDonorEnitity addNewDonor(BloodDonorDAO dao) ;
	 List<BloodDonorDAO> getAllusers();
	 
	
	 Object deleteDonor(int id) throws UserAlreadyDeletedException;
	 //get donor data
	 Object getMyProfile(String email) throws UserNotFoundException;
	 
	 //update user
	 BloodDonorEnitity updateDonor(BloodDonorDAO dao) ;
	 
	 //find user by id
	 BloodDonorDAO findUserById(int id) throws UserNotFoundException;
}
