package com.blackjack.Contracts;

public interface IAuthentication {

	public String getEmail();
	public String getPassword();
	public boolean getIsActive();
	
	public void setEmail( String email );
	public void setPassword( String password );
	public void setIsActive( boolean isActive );
}
