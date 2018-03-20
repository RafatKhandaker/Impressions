package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.blackjack.Contracts.IDBService;
import com.blackjack.Model.RegisterForm;
import com.blackjack.properties.ConfigProperties;
import com.blackjack.properties.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes("user")
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
		return viewResolver.getAccountSettingsIndex(); 
	}
				
	@PostMapping("/signup")
	public String newSignUp(Model model,
			@RequestParam("username") @ModelAttribute("user") String email, 
			@RequestParam("password") String password
			) {
		if( dbService.checkAccountExist(email) ) {  
			model.addAttribute("account_exist", configProp.getExistingAccMsg());
			return viewResolver.getLogin();
		}
		
		dbService.insertNewAccount(email, password);
		model.addAttribute("new_register", configProp.getRegisterMsg());
		return viewResolver.getRegister(); 
	}	
	
	@PostMapping("/register")
	public String registerProfile(Model model,
			@SessionAttribute("user") String user,
			@ModelAttribute("reg_form") RegisterForm regForm
			) {
		dbService.insertNewProfile(user, regForm);
		return viewResolver.getRegister(); 
	}
		
	// Temporary method to develop the page
	@GetMapping("/register")
	public String getRegister(Model model) { 
		model.addAttribute("reg_form", new RegisterForm());
		return viewResolver.getRegister(); 
		}
	
	
	@ModelAttribute("user")
	public Object userSessionAttribute() {
		return new Object();
	}
}
