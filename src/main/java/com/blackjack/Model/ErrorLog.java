package com.blackjack.Model;

import java.sql.Timestamp;
import java.util.Date;

import javax.validation.constraints.Null;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@SuppressWarnings("unused")
@Document(collection = "ErrorLog")
public class ErrorLog {
	
	@Id
	private String id;
	@Null
	private String password;
	@Null
	private String urlRequest;
	
	private String log;
	private String username;


	@Indexed(direction = IndexDirection.DESCENDING)
	private Timestamp timeStamp;
	
	
	public ErrorLog(String username, Exception error) {
		this.username = username;
		this.log = error.toString();
		this.timeStamp = new Timestamp(System.currentTimeMillis());
	}
	
	public ErrorLog(String username, String password, Exception error) {
		this.username = username;
		this.password = password;
		this.log = error.toString();	
		this.timeStamp = new Timestamp(System.currentTimeMillis());

	}
	
	public ErrorLog(String urlRequest, Exception error, boolean byHandler) {
		this.urlRequest = urlRequest;
		this.log = error.toString();
	}
}
