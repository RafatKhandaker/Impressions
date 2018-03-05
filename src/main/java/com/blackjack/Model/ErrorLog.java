package com.blackjack.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document(collection = "ErrorLog")
public class ErrorLog {
	private String username;
	private String password;
	private String log;
	
	public ErrorLog(String username, Exception error) {
		this.username = username;
		this.log = error.toString();
	}
	
	public ErrorLog(String username, String password, Exception error) {
		this.username = username;
		this.password = password;
		this.log = error.toString();	
	}
}
