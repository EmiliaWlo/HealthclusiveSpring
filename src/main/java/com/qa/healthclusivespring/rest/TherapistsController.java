package com.qa.healthclusivespring.rest;

import org.springframework.web.bind.annotation.RestController;

import com.qa.healthclusivespring.service.TherapistsService;

@RestController
public class TherapistsController {
	
	private TherapistsService service;
	
	
	
	
	public TherapistsController(TherapistsService service) {
		super();
		this.service = service;
	}
	
	
	
}
