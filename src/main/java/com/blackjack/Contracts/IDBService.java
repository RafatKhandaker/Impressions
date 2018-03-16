package com.blackjack.Contracts;

import com.blackjack.Model.Authentication;

public interface IDBService {
	
	public boolean isAuthenticated();
	
	public Authentication pullUserAccount(String email);

	public boolean checkAccountExist(String email);
	
	public void insertNewAccount(String email, String password);
	
}
