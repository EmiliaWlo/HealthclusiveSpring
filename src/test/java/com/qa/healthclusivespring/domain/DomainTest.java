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
	public void testToString() {
		
		
		Long id =3L ;
		 //id
	
		
		String date = "22/05/22";
		//date


		
		String phoneNumber = "08765088545";
		String name = " anya";
		
		Therapists anya = new Therapists(id, name, date, phoneNumber);
		Assert.assertEquals(anya.toString(),"Therapists [id=" + id + ", name=" + name + ", date=" + date + ", phoneNumber=" + phoneNumber + "]"); //phone number
	
		}
		
		
	}
	