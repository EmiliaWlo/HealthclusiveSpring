package com.qa.healthclusivespring.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.healthclusivespring.domain.Therapists;
import com.qa.healthclusivespring.rest.TherapistsController;
import com.qa.healthclusivespring.service.TherapistsService;

@SpringBootTest
public class ControllerTest {
	
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
	}
	
