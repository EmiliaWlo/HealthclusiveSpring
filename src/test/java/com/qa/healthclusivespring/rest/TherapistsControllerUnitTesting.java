package com.qa.healthclusivespring.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.qa.healthclusivespring.domain.Therapists;
import com.qa.healthclusivespring.service.TherapistsService;

@SpringBootTest
public class TherapistsControllerUnitTesting {
	@MockBean
	private TherapistsService service;
	
	@Autowired
	private TherapistsController controller;
	
	@Test
	public void testCreate() {
		
		Therapists testTherapists = new Therapists(1L, "id", "date", "phoneNumber");
		
		when(service.create(testTherapists)).thenReturn(testTherapists);
		
		assertThat(testTherapists).isEqualTo(controller.createMap(testTherapists));
	
		verify(service, times(1)).create(testTherapists);
		
		
	}
	
	@Test
	public void testReadAll() {
		
		Therapists testTherapists = new Therapists();
		List<Therapists> expected = List.of(testTherapists);
		
		when(service.create(testTherapists)).thenReturn(testTherapists);
		
		when(service.readAll()).thenReturn(expected);
		assertThat(controller.getAllTherapists()).isEqualTo(new ResponseEntity<>(expected, HttpStatus.OK));
		
		
		verify(service, times(1)).readAll();
		
	}
	
		

	@Test
	public void testReadById() {
		Long Id = 1L;
		Therapists testTherapists = new Therapists("kate" , "2022-05-22", "07685674343");
		Therapists expectedTherapists = new Therapists(1L, "kate" , "2022-05-22", "07685674343");
		
		when(service.create(testTherapists)).thenReturn(expectedTherapists);
		when(service.readById(Id)).thenReturn(expectedTherapists);
		assertThat(controller.getTherapists(Id)).isEqualTo(new ResponseEntity<>(expectedTherapists, HttpStatus.OK));
		Mockito.verify(service, Mockito.times(1)).readById(Id);
		
		
	}


	@Test
	public void testReadByDate() {
		String date = "2022-05-22";
		Therapists testTherapists = new Therapists("kate" , "2022-05-22", "07685674343");
		Therapists expectedTherapists = new Therapists(1L, "kate" , "2022-05-22", "07685674343");
		List<Therapists> expected = List.of(expectedTherapists);
		
		
		when(service.create(testTherapists)).thenReturn(expectedTherapists);
		when(service.readByDate(date)).thenReturn(expected);
		assertThat(controller.getByDate(date)).isEqualTo(new ResponseEntity<>(expected,HttpStatus.OK));
	
		verify(service, times(1)).readByDate(date);
		
	}
	
	@Test
	public void testReadByPhoneNumber() {
		String phoneNumber = "07685674343";
		Therapists testTherapists = new Therapists("kate" , "2022-05-22", "07685674343");
		Therapists expectedTherapists = new Therapists(1L, "kate" , "2022-05-22", "07685674343");
		
		
		when(service.create(testTherapists)).thenReturn(expectedTherapists);
		when(service.readByPhoneNumber(phoneNumber)).thenReturn(expectedTherapists);
		assertThat(controller.getByPhoneNumber(phoneNumber)).isEqualTo(new ResponseEntity<>(expectedTherapists, HttpStatus.OK));
	
		verify(service, times(1)).readByPhoneNumber(phoneNumber);
	}
	
	@Test
	public void testUpdateInfo() {
		Long Id = 1L;
		Therapists testTherapists = new Therapists("kate" , "2022-05-22", "07685674343");
		Therapists expectedTherapists = new Therapists(1L, "kate" , "2022-05-22", "07685674343");
		Therapists update = new Therapists("anya", "2022-04-22", "06754087912");
		Therapists updated = new Therapists(Id, update.getName(), update.getDate(), update.getPhoneNumber());
		
		when(service.create(testTherapists)).thenReturn(expectedTherapists);
		when(service.updateInfo(Id, update)).thenReturn(updated);
		assertThat(controller.updateTherapists(Id, update)).isEqualTo(new ResponseEntity<>(updated, HttpStatus.ACCEPTED));
	
		verify(service, times(1)).updateInfo(Id, update);
	}
	
	@Test
	public void testDeleteById(){
		Long Id = 1L;
		when(service.delete(Id)).thenReturn(true);
		assertThat(controller.removeTherapists(Id)).isEqualTo(new ResponseEntity<>(true, HttpStatus.NO_CONTENT));
	
		verify(service, times(1)).delete(Id);
	}
	
}
	
	
	
	
	
	
	
	