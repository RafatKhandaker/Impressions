package com.blackjack.AppStart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.blackjack.Security.AuthSecurity;

@Configuration
@EnableWebSecurity
public class AppSec extends WebSecurityConfigurerAdapter{
	
	private AuthSecurity authSec;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception{
		authSec = new AuthSecurity(http);
		authSec.addPagePermissions();
		authSec.ignoreResourceFolder(); 
		authSec.disableCSRFProtection();
	// authSec.enableCSRFProtection();
	
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	// Testing
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }
}
