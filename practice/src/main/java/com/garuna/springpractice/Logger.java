package com.garuna.springpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Dummy implementation of logger.
 */
@Component
public class Logger {

	private ConsoleWriter consoleWriter;
	private LogWriter fileWriter;

	@Autowired
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}

	@Autowired
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void init() {
		System.out.println("logger initiating");
	}

	public void destory() {
		System.out.println("logger destroying");
	}
	public void writeFile(String text) {
		fileWriter.write(text);
	}

	public void writeConsole(String text) {
		if (consoleWriter != null)
			consoleWriter.write(text);
	}

}
