package com.blackjack.Contracts;

import com.blackjack.Model.ErrorLog;

public interface ILogger {

	void insertLoginError(ErrorLog log);
}
