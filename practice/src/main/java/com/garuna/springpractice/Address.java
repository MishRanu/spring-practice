package com.garuna.springpractice;

import java.util.List;
import java.util.Set;

public class Address {

	private Long id;
	private String description;

	public Address(Long id, String description) {
		this.id = id;
		this.description = description;
	}

	public void init() {
		System.out.println("Bean created " + this);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", description=" + description + "]";
	}

}
