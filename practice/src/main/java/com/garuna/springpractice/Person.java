package com.garuna.springpractice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Person {
	
	private Long id; 
	private String name; 
	private int taxId; 
	private Address defaultAddress;
	private List<Address> addresses; 
	private Map<String, String> qualities = new HashMap<String, String>(); 
	private Map<String, Address> mapAddresses = new HashMap<String, Address>(); 
	
	
	public Map<String, Address> getMapAddresses() {
		return mapAddresses;
	}

	public void setMapAddresses(Map<String, Address> mapAddresses) {
		this.mapAddresses = mapAddresses;
	}

	public void setQualities(Map<String, String> qualities) {
		this.qualities = qualities;
	}

	public void setDefaultAddress(Address defaultAddress) {
		this.defaultAddress = defaultAddress;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Person(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public static Person getInstance(Long id, String name) {
		System.out.println("Creating person using factory method");
		return new Person(id, name); 
	}
	
	public void onCreate() {
		System.out.println("Person created" + this);
	}
	
	public void onDestroy() {
		System.out.println("Person destroyed");
	}

	public int getTaxId() {
		return taxId;
	}


	public void setTaxId(int taxId) {
		this.taxId = taxId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", taxId=" + taxId + ", defaultAddress=" + defaultAddress
				+ ", addresses=" + addresses + ", qualities=" + qualities + ", mapAddresses=" + mapAddresses + "]";
	}


}
