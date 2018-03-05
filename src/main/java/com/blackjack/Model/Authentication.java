package com.blackjack.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blackjack.Contracts.IAuthentication;

@Document(collection = "Authentication")
public class Authentication implements IAuthentication{

	@Id
	private String id;
	private String email;
	private String password;
	private boolean isActive;
	
	public Authentication(String email, String password, boolean isActive) {
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}
	
	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public boolean getIsActive() {
		return this.isActive;
	}


	@Override
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}
