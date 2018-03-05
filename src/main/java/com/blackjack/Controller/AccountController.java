package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.blackjack.Model.ViewResolver;

@Controller
@RequestMapping("/account")
public class AccountController  {
	
	@Autowired
	ViewResolver viewResolver;
	
	// home
	@GetMapping("/home")
	public String getHome() {
		/*MongoClient mongo = new MongoClient("localhost", 27017);
		String x = mongo.getDatabase("test").toString();
		System.out.println(x);
		mongo.close();
		*/
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
		
	
}
