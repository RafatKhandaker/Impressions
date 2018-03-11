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
	
	public LogError() {
	}

	@Override
	public void insertError(ErrorLog log) {
		this.eLogRepo.insert(log);
	}

}
