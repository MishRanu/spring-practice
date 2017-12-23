package com.garuna.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NewAddress {

	private Long id=0l;
	private String description="anurag address"; 

	
	public void init() {
		System.out.println("Bean created " + this);
	}
	
	public String getDescription() {
		return description;
	}

	@Autowired
	public void setDescription(@Value("${jdbc.password}") String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}
	
	@Autowired
	public void setId(@Value("#{person.name.length()}") Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NewAddress [id=" + id + ", description=" + description + "]";
	}


}
