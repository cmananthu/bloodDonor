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

import com.project.bloodDonor.custom.exceptions.UserAlreadyDeletedException;
import com.project.bloodDonor.custom.exceptions.UserNotFoundException;
import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.service.BloodDonorService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin("*") 
@RestController
public class BloodDonorController {
    
	@Autowired
	BloodDonorService service;
	
//	localhost:8085/bloodbank/add 
//	endpoint to add donor details
	@Operation(summary = "Add a new donor")
	//Swagger- gives definition to the end points
	@PostMapping("add")
	public ResponseEntity<Object> addDonor( @Validated @RequestBody BloodDonorDAO dao){
		return new ResponseEntity<>(service.addNewDonor(dao),HttpStatus.CREATED);
	}
	
	
	//localhost:8085/bloodbank/donors
	//fetch donors 
	@GetMapping("donors")
	@Operation(summary = "Get the details of all donors")
	public ResponseEntity<Object> getUsers(){
		return new ResponseEntity<>(service.getAllusers(),HttpStatus.OK);
	}
	//localhost:8085/bloodbank/myprofile/email
	@GetMapping("myprofile/{email}")
	@Operation(summary = "Get the details of donors with respect to email")
	public ResponseEntity<Object> getMyProfile(@PathVariable("email") String email) throws UserNotFoundException{
		
			return new ResponseEntity<>(service.getMyProfile(email),HttpStatus.OK);
		
	}
	

//	localhost:8085/bloodbank/delete/10
	@DeleteMapping("delete/{id}")
	@Operation(summary = "Delete the donor by email")
	public ResponseEntity<Object> deleteUsers(@PathVariable int id) throws UserAlreadyDeletedException{
		return new ResponseEntity<>(service.deleteDonor(id),HttpStatus.OK);
	}
	
//	localhost:8085/bloodbank/update 
//	endpoint to update donor details
	@PutMapping("update")
	@Operation(summary = "Update the details of a donor")
	public ResponseEntity<Object> updateDonorDetails( @Validated @RequestBody BloodDonorDAO dao){
		return new ResponseEntity<>(service.addNewDonor(dao),HttpStatus.OK);
	}
	
	//localhost:8085/bloodbank/donors/1
	//end point to fetch details of  donor by id
	@GetMapping("donors/{id}")
	@Operation(summary = "Get the details of a donor by Id")
	public ResponseEntity<Object> getById(@PathVariable("id") int id) throws UserNotFoundException{
		return new ResponseEntity<>(service.findUserById(id),HttpStatus.OK);
	}
	 
}
