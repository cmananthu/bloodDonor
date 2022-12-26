package com.project.bloodDonor.service;

import java.util.List;

import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;

public interface BloodDonorService {
	
	 BloodDonorEnitity addNewDonor(BloodDonorDAO dao) ;
	 List<BloodDonorDAO> getAllusers();
	 
	// BloodDonorDAO getUserById(int id);
	 String deleteDonor(int id);
	 
}
