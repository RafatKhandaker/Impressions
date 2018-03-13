package com.blackjack.Contracts;

import java.sql.Timestamp;
import java.util.List;

public interface IAuthentication {

	public boolean isActive();
	
	public Timestamp dateCreated();
	
	public Timestamp lastLogin();
	
	public <T> List<T> getAuthorization();

}
