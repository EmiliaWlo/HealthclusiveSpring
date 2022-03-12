package com.qa.healthclusivespring.service;

import java.util.List;
import java.util.Optional;

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
	public List<Therapists> readAll() {
		return this.repo.findAll();
	}

	public Therapists readById(Long id) {
		Optional<Therapists> op = this.repo.findById(id);
		return op.get();
	}
// update - getters and setters for each field, to update each field
	// individually
	public Therapists updateInfo(Long id, Therapists info) {
		Therapists existing = this.repo.getById(id);
		existing.setName(info.getName());
		existing.setDate(info.getDate());
		existing.setPhoneNumber(info.getPhoneNumber());
		return this.repo.save(existing);
	}
	// delete - deleteById
	public boolean delete(long id) {
		this.repo.deleteById(id);

		return !this.repo.existsById(id);
	}

	
	
}
