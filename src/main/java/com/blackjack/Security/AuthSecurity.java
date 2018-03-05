package com.blackjack.Security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.blackjack.Contracts.IAppSecurity;

public class AuthSecurity implements IAppSecurity{
	
	private HttpSecurity http;
	private List<String> openPages = new ArrayList<>();
	private String logPage;
	private String resFolder;
	
	public AuthSecurity(HttpSecurity http){
		this.http = http;	
		this.openPages.addAll(
				Arrays.asList(
						"/",
						"/welcome",
						"/account/",
						"/resources/static/**",
						"/login/login"
						)
				);
		this.logPage = "/login/admin";
		this.resFolder = "/resources/static/**";
	}

	@Override
	public void addPagePermissions() throws Exception {
		
		this.http.authorizeRequests()
			.antMatchers(
					this.openPages.get(0), 
					this.openPages.get(1), 
					this.openPages.get(2), 
					this.openPages.get(3), 
					this.openPages.get(4)
					).permitAll().anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage(
						this.logPage
						).permitAll()
				.and()
			.logout()
				.permitAll();		
	}

	@Override
	public void ignoreResourceFolder() throws Exception {
		this.http.authorizeRequests().antMatchers(this.resFolder).permitAll().anyRequest().permitAll();

	}

	@Override
	public void enableCSRFProtection() throws Exception {
		this.http
			.csrf()
				.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());		
	}

	@Override
	public void disableCSRFProtection() throws Exception {
		this.http
			.csrf().disable();		
	}


	
	
}
