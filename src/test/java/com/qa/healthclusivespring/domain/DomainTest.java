package com.qa.healthclusivespring.domain;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import nl.jqno.equalsverifier.EqualsVerifier;

@SpringBootTest
public class DomainTest {
	public Therapists Therapists;
	
	@Test //testing getters
	public void testGetters() {
		Therapists = new Therapists(1L, "name", "date", "number");
		
		assertNotNull(Therapists.getId());
		assertNotNull(Therapists.getName());
		assertNotNull(Therapists.getDate());
		assertNotNull(Therapists.getPhoneNumber());
				
	}
	
	@Test //testing setters
	public void testSetters( ) {
		Therapists = new Therapists();
		Therapists.setId(null);
		assertNull(Therapists.getId());
		
		Therapists.setName(null);
		assertNull(Therapists.getName());
		
		Therapists.setDate(null);
		assertNull(Therapists.getDate());
		
		Therapists.setPhoneNumber(null);
		assertNull(Therapists.getPhoneNumber());
				
	}
	
	@Test //hashcode and equals
	public void simpleEqualsContract() {
		EqualsVerifier.simple().forClass(Therapists.class).verify();}

	
	@Test //testing toString
	public String testToString() {
		
		Therapists = new Therapists();
			
		String id = (testToString());
		Assert.assertEquals(Therapists.toString(), id); //id
		
		String date = (testToString());
		Assert.assertEquals(Therapists.toString(), date); //date
		
		String Long = (testToString());
		Assert.assertEquals(Therapists.toString(), Long); //name
		
		String phoneNumber = (testToString());
		Assert.assertEquals(Therapists.toString(), phoneNumber); //phone number
		return phoneNumber;
		
	
		}
		
		
	}
	