package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.blackjack.Contracts.IDBService;
import com.blackjack.Model.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/login")
public class LoginController{

	@Autowired
	ViewResolver viewResolver;
	@Autowired
	IDBService dbService;
	
	// index 
	@GetMapping("/index")
	public String getIndex() {
		return viewResolver.getLoginIndex();
	}
	
	// profile 
	@GetMapping("/login")
	public String getProfile() {
		return viewResolver.getLogin();
	}	
		
	@PostMapping("/login")
	public String postProfile(@RequestParam("username") String email, @RequestParam("password") String password) {
		
		if(dbService.checkLoginCred(email, password)) { 
			return viewResolver.getLoginIndex(); 
			};
		
		return viewResolver.getLogin();
	}
				
		
}
