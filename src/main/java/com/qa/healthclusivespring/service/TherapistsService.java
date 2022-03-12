package com.qa.healthclusivespring.service;

import org.springframework.stereotype.Service;

import com.qa.healthclusivespring.domain.Therapists;
import com.qa.healthclusivespring.repo.TherapistsRepo;

@Service
public class TherapistsService {
	
	private TherapistsRepo repo;

	public TherapistsService(TherapistsRepo repo) {
		super();
		this.repo = repo;
	}
	
	//create-logic
	
	public Therapists create(Therapists newTherapist) {
		return this.repo.save(newTherapist);
		
	}

}
