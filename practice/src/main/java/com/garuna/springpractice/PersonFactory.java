package com.garuna.springpractice;

public class PersonFactory {
	public Person getInstance(Long id, String name) {
		System.out.println("Creating person using factory class");
		return new Person(id, name); 
	}
}
