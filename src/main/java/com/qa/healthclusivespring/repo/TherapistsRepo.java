package com.qa.healthclusivespring.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.healthclusivespring.domain.Therapists;
@Repository
public interface TherapistsRepo extends JpaRepository<Therapists, Long> {
//	@Query(value = "select * from therapists where date")
	public List<Therapists> findAllByDate(String date);
	
	public List<Therapists> findAllByPhoneNumber(String phoneNumber);
	
}