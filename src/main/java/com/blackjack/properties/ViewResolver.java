package com.blackjack.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
 public final class ViewResolver {
	
	 @Value("${view.welcome}")
	 private String welcomePage;
	 
	 @Value("${view.home}")
	 private String homePage;	
	 
	 @Value("${view.profile}")
	 private String profilePage;
	 
	 @Value("${view.site-settings}")
	 private String siteSettingsPage;
	 
	 @Value("${view.login}")
	 private String loginPage;
	 
	 @Value("${view.login-index}")
	 private String loginIndexPage;
	 
	 @Value("${view.account-settings-index}")
	 private String accountSettingsIndexPage;
	 
	public ViewResolver() {}
	 
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
	 
	 public String getAccountSettingsIndex() {
		 return this.accountSettingsIndexPage;
	 }
}
