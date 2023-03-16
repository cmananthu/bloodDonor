package com.project.bloodDonor.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.project.bloodDonor.service.BloodDonorService;
import com.project.bloodDonor.util.BloodDonorUtilTest;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(BloodDonorController.class)
//@SpringBootTest
class BloodDonorControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BloodDonorService service;

	@InjectMocks
	private BloodDonorController controller;

	// test case for postmapping
	@Test
	void testAddDonor() throws JsonProcessingException, Exception {
		Mockito.when(service.addNewDonor(Mockito.any())).thenReturn(BloodDonorUtilTest.prepareBloodDonorEntity());

		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON)
				.content(BloodDonorUtilTest.toJson(BloodDonorUtilTest.prepareBloodDonorDAO())))
				.andExpect(status().isCreated()).andExpect(jsonPath("$.id", is(1)))
				.andExpect(jsonPath("$.email", is("anan@gamil.com")))

		;
	}

	// test case for getmapping
	@Test
	void testGetUsers() throws Exception {
		Mockito.when(service.getAllusers()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorDAO());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/donors")).andExpect(status().isOk());
	}

	// test case for getmapping with email
	@Test
	void testGetMyProfile() throws Exception {
		// Mockito.when(service.getAllusers()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorDAO());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/myprofile/anan@gamil.com")).andExpect(status().isOk());
	}

	// test case for deleteMappting
	@Test
	void testDeleteUsers() throws Exception {
		// Mockito.when(service.getAllusers()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorDAO());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(delete("/delete/1")).andExpect(status().isOk());
	}

	// test case for putMapping
	@Test
	void testUpdateDonorDetails() throws Exception {
		// Mockito.when(service.getAllusers()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorDAO());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(put("/update").contentType(MediaType.APPLICATION_JSON)
				.content(BloodDonorUtilTest.toJson(BloodDonorUtilTest.prepareBloodDonorDAO())))
				.andExpect(status().isOk());
	}

	// test case for getmapping with id
	@Test
	void testGetById() throws Exception {
		// Mockito.when(service.getAllusers()).thenReturn(BloodDonorUtilTest.prepareListofBloodDonorDAO());
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/donors/1")).andExpect(status().isOk());
	}

}
