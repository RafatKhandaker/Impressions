package com.blackjack.Contracts;

import java.sql.Timestamp;

public interface IAuthentication {

	public boolean isActive();
	
	public Timestamp dateCreated();
	
	public Timestamp lastLogin();
	
}
