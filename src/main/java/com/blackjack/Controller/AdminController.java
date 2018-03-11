package com.blackjack.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.blackjack.properties.ViewResolver;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ViewResolver viewResolver;
	
		@GetMapping("/home")
		public String getSiteSettings() {			
			return viewResolver.getSiteSettings();
		}
		
		@PostMapping("home")
		public String postSiteSettings() {
			return viewResolver.getSiteSettings();
		}
		
}
