package com.blackjack.Contracts;

import com.blackjack.Model.Authentication;

public interface IDBService {
	
	public boolean isAuthenticated();
	
	public Authentication pullUserAccount(String email);

	public boolean checkLoginCred(String email, String password);
	
	public void insertNewAccount(String email, String password);
	
}
