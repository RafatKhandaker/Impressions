package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.blackjack.Contracts.IDBService;
import com.blackjack.properties.ConfigProperties;
import com.blackjack.properties.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@Autowired
	ConfigProperties configProp;
	
	// index 
	@GetMapping("/index")
	public String getIndex() {
		return viewResolver.getLoginIndex();
	}
	
	// profile 
	@GetMapping("/login")
	public String getLogin() {
		return viewResolver.getLogin();
	}	
		
	@PostMapping("/login")
	public String submitLogin() {
		return viewResolver.getAccountSettingsIndex(); 
	}
				
	@PostMapping("/register")
	public String registerProfile(Model model,
			@RequestParam("username") String email, 
			@RequestParam("password") String password
			) {
		
		if(!dbService.checkLoginCred(email, password)) {  
			dbService.insertNewAccount(email, password);
			return viewResolver.getLogin(); 
			}
		model.addAttribute("message", configProp.getRegisterMsg());
		return viewResolver.getLogin();
	}	
		
}
