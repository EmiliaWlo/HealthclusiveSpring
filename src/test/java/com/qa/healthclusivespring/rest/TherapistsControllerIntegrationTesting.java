package com.qa.healthclusivespring.rest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.healthclusivespring.domain.Therapists;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
@AutoConfigureMockMvc 
@Sql(scripts = { "classpath:schema-test.sql",
"classpath:data-test.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles = "test")
public class TherapistsControllerIntegrationTesting {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ObjectMapper jsonifier;
		
	@Test
	void testCreate() throws Exception {
		Therapists testTherapists = new Therapists("kate", "2022-04-22", "07685674343");
		Therapists expectedTherapists = new Therapists(2L, "kate", "2022-04-22", "07685674343");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "http://localhost8080/create")
		.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(testTherapists))
		.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedTherapists));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
		
		
				
	}
	
	@Test
	void testReadAll() throws Exception {
		List<Therapists> expected = List.of(new Therapists(1L, "kate", "2022-04-22", "07685674343"));
		MockHttpServletRequestBuilder MockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost8080/getAll");
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expected));
		this.mock.perform(MockRequest).andExpect(status).andExpect(content);
		
	}
	
	
	
	@Test
	void testReadById() throws Exception {
		Long Id = 1L;
		Therapists expected = new Therapists(1L, "kate", "2022-04-22", "07685674343");
		MockHttpServletRequestBuilder MockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost8080/get/"+Id);
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expected));
		this.mock.perform(MockRequest).andExpect(status).andExpect(content);
		
	}
	
	@Test
	void testReadByDate() throws Exception {
		String date = "2022-04-22";
		List<Therapists> expected = List.of(new Therapists(1L, "kate", "2022-04-22", "07685674343"));
		MockHttpServletRequestBuilder MockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost8080/read/"+date);
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expected));
		this.mock.perform(MockRequest).andExpect(status).andExpect(content);
		
	}
	
	@Test
	void testReadByPhoneNumber() throws Exception {
		String phoneNumber = "07685674343";
		Therapists expected = new Therapists(1L, "kate", "2022-04-22", "07685674343");
		MockHttpServletRequestBuilder MockRequest = MockMvcRequestBuilders.request(HttpMethod.GET, "http://localhost8080/readByPhoneNumber/"+phoneNumber);
		ResultMatcher status = MockMvcResultMatchers.status().isOk();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expected));
		this.mock.perform(MockRequest).andExpect(status).andExpect(content);
		
	}
	
	@Test
	void testUpdateInfo() throws Exception {
		Long Id = 1L;	
		Therapists testTherapists = new Therapists("anya", "2022-04-22", "07685674343");
		Therapists expectedTherapists = new Therapists(1L, "anya", "2022-04-22", "07685674343");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.PUT, "http://localhost8080/update/"+Id)
		.contentType(MediaType.APPLICATION_JSON).content(jsonifier.writeValueAsString(testTherapists))
		.accept(MediaType.APPLICATION_JSON);
		
		ResultMatcher status = MockMvcResultMatchers.status().isAccepted();
		ResultMatcher content = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedTherapists));
		
		this.mock.perform(mockRequest).andExpect(status).andExpect(content);
	}
	
	@Test
	void testDeleteById() throws Exception {
		Long Id = 1L;
		MockHttpServletRequestBuilder MockRequest = MockMvcRequestBuilders.request(HttpMethod.DELETE, "http://localhost8080/remove/"+Id);
		ResultMatcher status = MockMvcResultMatchers.status().isNoContent();
		
		this.mock.perform(MockRequest).andExpect(status);
		
	}
	
	
}
