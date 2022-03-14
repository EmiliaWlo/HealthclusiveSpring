package com.qa.healthclusivespring.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // marks this class as a table
public class Therapists {

	// columns for the table

	@Id // marks it as a primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_incrementation
	private Long id;

	private String name;
	private String date;
	private String phoneNumber;

	// 3 types of constructors

	// empty constructor
	public Therapists() {
		super();
	}

	// constructor with everything, including id
	public Therapists(Long id, String name, String date, String phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}

	// constructor with everything but id
	public Therapists(String name, String date, String phoneNumber) {
		super();
		this.name = name;
		this.date = date;
		this.phoneNumber = phoneNumber;
	}

	// Getters and setters- note that they are especially important with updates
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	// toString
	@Override
	public String toString() {
		return "Therapists [id=" + id + ", name=" + name + ", date=" + date + ", phoneNumber=" + phoneNumber + "]";
	}
	
	// hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(date, name, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Therapists other = (Therapists) obj;
		return Objects.equals(date, other.date) && Objects.equals(name, other.name)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}


}
