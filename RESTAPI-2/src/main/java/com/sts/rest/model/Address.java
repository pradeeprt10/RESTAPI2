package com.sts.rest.model;


import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {

	@Id
	private int zipcode;
	private String city;
	private String state;	
	@OneToOne(mappedBy ="address")
	@JsonBackReference
	private Employee book;
	
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Employee getBook() {
		return book;
	}
	public void setBook(Employee book) {
		this.book = book;
	}
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address(int zipcode, String city, String state, Employee book) {
		super();
		this.zipcode = zipcode;
		this.city = city;
		this.state = state;
		this.book = book;
	}
	
	
	
}
