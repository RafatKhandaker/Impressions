package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.blackjack.properties.ViewResolver;

@Controller
public class WelcomeController {
	
	@Autowired
	ViewResolver viewResolver;
	
	
	@GetMapping("*")
	public String welcome() {
	    return viewResolver.getWelcome();
	}
	
}
