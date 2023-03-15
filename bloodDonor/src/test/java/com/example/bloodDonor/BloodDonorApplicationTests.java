package com.example.bloodDonor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.bloodDonor.BloodDonorApplication;

@ExtendWith(MockitoExtension.class)

class BloodDonorApplicationTests {

	@Test
	void contextLoads() {
		BloodDonorApplication.main(new String[] {});
	}

}
