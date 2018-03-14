package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackjack.properties.ViewResolver;

@Controller
@RequestMapping("/account")
public class AccountController  {
	
	@Autowired
	ViewResolver viewResolver;
	
	// home
	@GetMapping("/home")
	public String getHome() {
		return viewResolver.getHome();
	}
	
	@PostMapping("/home")
	public String postHome() {
		return viewResolver.getHome();
	}
	

	// profile 
	@GetMapping("/profile")
	public String getProfile() {
		return viewResolver.getProfile();
	}
	
	@PostMapping("/profile")
	public String postProfile() {
		return viewResolver.getProfile();
	}
		
//	@PreAuthorize("hasAnyRole('user')")
	@GetMapping("/settings/index")
	public String getSettingsIndex() {
		return viewResolver.getAccountSettingsIndex();
	}
}
