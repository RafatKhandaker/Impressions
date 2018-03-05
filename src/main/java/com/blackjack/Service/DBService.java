package com.blackjack.Service;

import java.util.List;

import com.blackjack.Contracts.IAuthentication;
import com.blackjack.Contracts.IDBService;
import com.blackjack.Contracts.IProfile;
import com.blackjack.Contracts.IResponse;
import com.blackjack.Contracts.ISurvey;

public class DBService<T> implements IDBService {

	private IAuthentication authentication;
	private List<IProfile> profile;
	private List<IResponse> response;
	private List<ISurvey<T>> survey;
	
	public DBService(){}
	
	public DBService(IAuthentication authentication){
		this.authentication = authentication;
	}

	public DBService(IAuthentication authentication, List<IProfile> profile, List<IResponse> response, List<ISurvey<T>> survey){
		this.authentication = authentication;
		this.profile = profile;
		this.response = response;
		this.survey = survey;
	}

	@Override
	public boolean isAuthenticated() {
		return this.authentication.getIsActive();
	}

	@Override
	public boolean checkLoginCred() {
		// TODO Auto-generated method stub
		return false;
	}
}
