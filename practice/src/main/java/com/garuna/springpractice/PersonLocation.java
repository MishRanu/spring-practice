package com.garuna.springpractice;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonLocation {

	private Person person; 
	private Address address;
	
	public void init() {
		System.out.println("PersonLocation created " + person + " address " + address); 
	}

	public PersonLocation(Person person, Address address) {
 		this.person = person;
		this.address = address;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "PersonLocation [person=" + person + ", address=" + address + "]";
	} 
	
	
	
}
