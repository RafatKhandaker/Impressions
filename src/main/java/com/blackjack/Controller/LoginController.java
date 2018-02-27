package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.blackjack.Model.ViewResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/welcome")
public class LoginController {

	@Autowired
	ViewResolver viewResolver;
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
	public String postProfile() {
		return viewResolver.getLogin();
	}
				
		
}
