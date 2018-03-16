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
	public String submitLogin(Model model) {
		model.addAttribute("account_exist", "");
		return viewResolver.getAccountSettingsIndex(); 
	}
				
	@PostMapping("/register")
	public String registerProfile(Model model,
			@RequestParam("username") String email, 
			@RequestParam("password") String password
			) {
		
		if( !dbService.checkAccountExist(email) ) {  
			dbService.insertNewAccount(email, password);
			model.addAttribute("new_register", configProp.getRegisterMsg());
			
			return viewResolver.getRegister(); 
			}
		
		model.addAttribute("account_exist", configProp.getExistingAccMsg());
		return viewResolver.getLogin();
	}	
		
	// Temporary method to develop the page
	@GetMapping("/register")
	public String getRegister() { return viewResolver.getRegister(); }
}
