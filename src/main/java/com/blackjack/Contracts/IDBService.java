package com.blackjack.Contracts;

public interface IDBService {
	
	public boolean isAuthenticated();
	
	public boolean checkLoginCred(String email, String password);
	
	public void insertNewAccount(String email, String password);
}
