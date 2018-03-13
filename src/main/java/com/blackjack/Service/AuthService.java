package com.blackjack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blackjack.Contracts.IDBService;
import com.blackjack.Model.Authentication;

@Component
public class AuthService implements UserDetailsService{

	@Autowired
	IDBService dbService;
	 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Authentication authModel = dbService.pullUserAccount(email);
		
		return new Authentication(
				authModel.getUsername(), 
				authModel.getPassword(), 
				authModel.getAuthorization()
				);
				
	}

}
