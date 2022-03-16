package com.qa.healthclusivespring.service;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import com.qa.healthclusivespring.domain.Therapists;
import com.qa.healthclusivespring.repo.TherapistsRepo;

@SpringBootTest
public class TherapistsServiceUnitTesting {

	@MockBean
	private TherapistsRepo repo;
	
	@Autowired
	private TherapistsService service;
	
	@Test
	public void testCreate() {
		Therapists testTherapists = new Therapists("id", "date", "phoneNumber");
		Therapists expectedTherapists = new Therapists(1L, "id", "date", "phoneNumber");
		Mockito.when(this.repo.save(testTherapists)).thenReturn(expectedTherapists);
		assertThat(this.service.create(testTherapists)).isEqualTo(expectedTherapists);
		Mockito.verify(this.repo, Mockito.times(1)).save(testTherapists);
	}
	
	
	
}
