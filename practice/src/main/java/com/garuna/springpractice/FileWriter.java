package com.garuna.springpractice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FileWriter implements LogWriter {

	public void write(String text) {
		// Write to a file here.
		// Dummy implementation
		System.out.println("Write to file: " + text);
		
	}

}
