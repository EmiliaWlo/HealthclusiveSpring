package com.qa.healthclusivespring.rest;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	public Therapists createMap(@RequestBody Therapists info) {
		return this.service.create(info);
	}
			

	//HTTP responses 
	
	//readAll - get request - list
	@GetMapping("/getAll")
	public ResponseEntity<List<Therapists>> getAllTherapists(){
		return new ResponseEntity<List<Therapists>>(this.service.readAll(), HttpStatus.OK);
	}
	
	//readById - get request - 1 record
		
	@GetMapping("/get/{id}")
	public ResponseEntity<Therapists> getTherapists(@PathVariable Long id){
		return new ResponseEntity<Therapists>(this.service.readById(id), HttpStatus.OK);	
	}
	
	//custom function
	@GetMapping("/read/{date}")
	public ResponseEntity<List<Therapists>> getByDate(@PathVariable String date) {
		return new ResponseEntity<>(this.service.readByDate(date), HttpStatus.OK);
		
	}
	//custom function
	@GetMapping("/readByPhoneNumber/{phoneNumber}")
	public ResponseEntity<List<Therapists>> getByPhoneNumber(@PathVariable String phoneNumber) {
		return new ResponseEntity<>(this.service.readByPhoneNumber(phoneNumber), HttpStatus.OK);
		
	}
	
	//update - put request - need id ( you can use path param or path variables) and a body for it
	
		
	@PutMapping("/update/{id}")
	public ResponseEntity<Therapists> updateTherapists(@PathVariable Long id, @RequestBody Therapists newInfo) {
		return new ResponseEntity<Therapists>(this.service.updateInfo(id,newInfo), HttpStatus.ACCEPTED);
	 }
	
	
	//delete - delete request - need id 
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> removeTherapists(@PathVariable Long id){
		return new ResponseEntity<>(this.service.delete(id),HttpStatus.NO_CONTENT);
	}
}
