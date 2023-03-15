package com.project.bloodDonor.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bloodDonor.entity.BloodDonorDAO;
import com.project.bloodDonor.entity.BloodDonorEnitity;

public class BloodDonorUtilTest {
	//Mock object BloodDonorDAO
   public static BloodDonorDAO prepareBloodDonorDAO() {
	   BloodDonorDAO dao=new BloodDonorDAO();
	   dao.setAge("18");
	   dao.setBloodGroup("A+");
	   dao.setBmi(16.5);
	   dao.setCity("kottayam");
	   dao.setDonorName("ananth");
	   dao.setEmail("anan@gamil.com");
	   dao.setGender("male");
	   dao.setId(1);
	   return dao;
   }
   
 //Mock object BloodDonorEnitity
   public static BloodDonorEnitity prepareBloodDonorEntity() {
	   BloodDonorEnitity e=new BloodDonorEnitity();
	   e.setAge("18");
	   e.setBloodGroup("A+");
	   e.setBmi(16.5);
	   e.setCity("kottayam");
	   e.setDonorName("ananth");
	   e.setEmail("anan@gamil.com");
	   e.setGender("male");
	   e.setId(1);
	   return e;
   }
   
   //Mock List<BloodDonorEnitity>
   public static List<BloodDonorEnitity> prepareListofBloodDonorEntity(){
	   List lst=new ArrayList<>();
	   lst.add(prepareBloodDonorEntity());
	   return lst;
   }
   
 //Mock List<BloodDonorDAO>
   public static List<BloodDonorDAO> prepareListofBloodDonorDAO(){
	   List lst=new ArrayList<>();
	   lst.add(prepareBloodDonorDAO());
	   return lst;
   }
   
   //convert obj to json
   private static final ObjectMapper objectMapper = new ObjectMapper();

   public static String toJson(Object object) throws JsonProcessingException {
       return objectMapper.writeValueAsString(object);
   }
}
