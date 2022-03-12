package com.qa.healthclusivespring.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.healthclusivespring.domain.Therapists;
import com.qa.healthclusivespring.service.TherapistsService;

@RestController
public class TherapistsController {
	private TherapistsService service;

	public TherapistsController(TherapistsService service) {
		super();
		this.service = service;
		
	}
		
	//create (post request)
	@PostMapping("/create")
	public Therapists createMap(@RequestBody Therapists t) {
		return this.service.create(t);
		
		
	}
	
		
}
