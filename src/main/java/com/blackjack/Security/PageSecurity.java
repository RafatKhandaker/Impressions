package com.blackjack.Security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.blackjack.Contracts.IAppSecurity;

public class PageSecurity implements IAppSecurity{
	
	private HttpSecurity http;
	
	private List<String> securePages = new ArrayList<>();
	private List<String> openPages = new ArrayList<>();

	private String logPage;
	private String resFolder;
	
	public PageSecurity(HttpSecurity http){
		this.http = http;	
		this.securePages.addAll(
				Arrays.asList(
						"/admin/**",
						"/account/settings/**"
						)
				);
		this.openPages.addAll( Arrays.asList( "login/**") );
		this.logPage = "/login/login";
		this.resFolder = "/resources/static/**";
	}

	@Override
	public void addPagePermissions() throws Exception {
		
		this.http.authorizeRequests()
			.antMatchers(
					this.securePages.get(0),
					this.securePages.get(1)
					)
			.authenticated()
				.and()
			.formLogin()
				.loginPage(
						this.logPage
						)
				.permitAll()
				.and()
			.logout()
				
				.permitAll();		
	}

	@Override
	public void ignoreResourceFolder() throws Exception {
		this.http
			.authorizeRequests()
			.antMatchers(this.resFolder)
			.permitAll()
			.anyRequest()
			.permitAll();

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
