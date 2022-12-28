package com.project.bloodDonor.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bloodDonor.entity.BloodDonorEnitity;

public interface BloodDonorRepository extends JpaRepository<BloodDonorEnitity, Integer> {
	BloodDonorEnitity findByEmail(String email);
}
