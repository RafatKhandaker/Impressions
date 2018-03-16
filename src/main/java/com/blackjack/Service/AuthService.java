package com.blackjack.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.blackjack.Contracts.IDBService;

@Component
public class AuthService implements UserDetailsService{

	@Autowired
	IDBService dbService;
	 
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 return dbService.pullUserAccount(email);
					
	}

}
