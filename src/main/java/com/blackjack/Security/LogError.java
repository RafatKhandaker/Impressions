package com.blackjack.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blackjack.Contracts.ILogger;
import com.blackjack.Model.ErrorLog;
import com.blackjack.Repository.ErrorLogRepository;

@Component
public class LogError implements ILogger {

	@Autowired
	private ErrorLogRepository eLogRepo;
	private ErrorLog log;
	
	public LogError(ErrorLog log) {
		this.log = log;
	}

	@Override
	public void insertLoginError() throws Exception {
		this.eLogRepo.insert(this.log);
	}	
	
}
