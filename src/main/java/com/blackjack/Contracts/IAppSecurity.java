package com.blackjack.Contracts;

public interface IAppSecurity {

	public void addPagePermissions() throws Exception;
	
	public void ignoreResourceFolder() throws Exception;
	
	public void enableCSRFProtection() throws Exception;
	
	public void disableCSRFProtection() throws Exception;
}
