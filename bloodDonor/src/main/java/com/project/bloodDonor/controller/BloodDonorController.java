package com.project.bloodDonor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;
import com.project.bloodDonor.service.BloodDonorService;
import com.project.bloodDonor.serviceImpl.BloodDonorServiceImpl;

@CrossOrigin("*") 
@RestController
public class BloodDonorController {
    
	@Autowired
	BloodDonorService service;
	
//	localhost:8085/bloodbank/add 
//	endpoint to add donor details
	@PostMapping("add")
	public ResponseEntity<Object> addDonor( @Validated @RequestBody BloodDonorDAO dao){
		return new ResponseEntity<>(service.addNewDonor(dao),HttpStatus.CREATED);
	}
	
	
	//localhost:8085/bloodbank/donors
	//fetch donors 
	@GetMapping("donors")
	public ResponseEntity<Object> getUsers(){
		return new ResponseEntity<>(service.getAllusers(),HttpStatus.OK);
	}
	//localhost:8085/bloodbank/myprofile/email
	@GetMapping("myprofile/{email}")
	public ResponseEntity<Object> getMyProfile(@PathVariable("email") String email){
		return new ResponseEntity<>(service.getMyProfile(email),HttpStatus.OK);
	}
	

//	localhost:8085/bloodbank/delete/10
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteUsers(@PathVariable int id){
		return new ResponseEntity<>(service.deleteDonor(id),HttpStatus.OK);
	}
	
//	localhost:8085/bloodbank/update 
//	endpoint to update donor details
	@PutMapping("update")
	public ResponseEntity<Object> updateDonorDetails( @Validated @RequestBody BloodDonorDAO dao){
		return new ResponseEntity<>(service.addNewDonor(dao),HttpStatus.OK);
	}
	
	//localhost:8085/bloodbank/donors/1
	//end point to fetch details of  donor by id
	@GetMapping("donors/{id}")
	public ResponseEntity<Object> getById(@PathVariable("id") int id){
		return new ResponseEntity<>(service.findUserById(id),HttpStatus.OK);
	}
	 
}
