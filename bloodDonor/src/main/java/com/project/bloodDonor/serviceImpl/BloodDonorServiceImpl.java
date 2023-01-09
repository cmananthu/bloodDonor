package com.project.bloodDonor.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;
import com.project.bloodDonor.repository.BloodDonorRepository;
import com.project.bloodDonor.service.BloodDonorService;
import com.project.bloodDonor.util.BloodDonorUtil;

@Service
public class BloodDonorServiceImpl implements BloodDonorService{
	
	@Autowired
	BloodDonorRepository repo;

	//add new donor
	@Override
	public BloodDonorEnitity addNewDonor(BloodDonorDAO dao) {
		BloodDonorEnitity entity=BloodDonorUtil.createBloodDonorEntity(dao);
		
		return repo.save(entity);
	}

	//find all donor
	@Override
	public List<BloodDonorDAO> getAllusers() {
		
			return BloodDonorUtil.createListofBloodDonorDAO(repo.findAll());

	}
//
//	@Override
//	public BloodDonorDAO getUserById(int id) {
//		//return BloodDonorUtil.createBloodDonorDAO(repo.findById(id));
//	}

	@Override
	public String deleteDonor(int id) {
		repo.deleteById(id);
		return "succesfully deleted donor";
	}

	@Override
	public Object getMyProfile(String email) {
		BloodDonorEnitity e=repo.findByEmail(email);
		BloodDonorDAO dao=BloodDonorUtil.createBloodDonorDAO(e);
		return dao;
	}

	@Override
	public BloodDonorEnitity updateDonor(BloodDonorDAO dao) {
       BloodDonorEnitity entity=BloodDonorUtil.createBloodDonorEntity(dao);
		
		return repo.save(entity);
	}

	@Override
	public BloodDonorDAO findUserById(int id) {
		BloodDonorEnitity ent=repo.findById(id);
		BloodDonorDAO dao=BloodDonorUtil.createBloodDonorDAO(ent);
		return dao;
	}

	
	
	

}
