package com.blackjack.Contracts;

import com.blackjack.Model.ErrorLog;

public interface ILogger {

	void insertError(ErrorLog log);
}
