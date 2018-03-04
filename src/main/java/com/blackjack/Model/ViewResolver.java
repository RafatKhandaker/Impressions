package com.blackjack.Model;

import org.springframework.stereotype.Component;

@Component
 public class ViewResolver {
	 
	 private String welcomePage;
	 private String homePage;
	 private String profilePage;
	 private String siteSettingsPage;
	 private String loginPage;
	 private String loginIndexPage;
	 
	public ViewResolver() {
		this.welcomePage = "welcome";
		this.homePage = "/account/home";
		this.profilePage = "/account/profile";
		this.siteSettingsPage = "/admin/site-setting";
		this.loginPage = "/login/login";
		this.loginIndexPage = "/login/index";
	}
	 
	 public String getWelcome() {
		 return this.welcomePage;
	 }
	 
	 public String getHome() {
		return this.homePage;
	 }
	 
	 public String getProfile() {
		 return this.profilePage;
	 }
	 
	 public String getSiteSettings() {
		 return this.siteSettingsPage;
	 }
	 
	 public String getLogin() {
		 return this.loginPage;
	 }
	 
	 public String getLoginIndex() {
		return this.loginIndexPage;
	 }
}
