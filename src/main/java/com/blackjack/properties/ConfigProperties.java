package com.blackjack.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class ConfigProperties {

	@Value("${model.register.msg}")
	private String registerMsg;
	
	@Value("${model.login.msg}")
	private String loginMsg;
	
	@Value("${model.existing.acc}")
	private String existingAccMsg;
	
	public ConfigProperties(){}
	
	public String getRegisterMsg() {
		return this.registerMsg;
	}
	
	public String getLoginMsg() {
		return this.loginMsg;
	}
	
	public String getExistingAccMsg() {
		return this.existingAccMsg;
	}
}
