package com.blackjack.Service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.blackjack.Contracts.IAuthentication;
import com.blackjack.Contracts.IDBService;
import com.blackjack.Contracts.IProfile;
import com.blackjack.Contracts.IResponse;
import com.blackjack.Contracts.ISurvey;
import com.blackjack.Repository.AuthenticationRepository;
import com.blackjack.Repository.CommentsRepository;
import com.blackjack.Repository.QuestionsRepository;
import com.blackjack.Repository.RepliesRepository;
import com.blackjack.Repository.SurveysRepository;
import com.blackjack.Repository.UserProfilesRepository;

@Component
public class DBService<T> implements IDBService {

	private AuthenticationRepository authRepo;
	private CommentsRepository commRepo;
	private QuestionsRepository qRepo;
	private RepliesRepository repRepo;
	private SurveysRepository survRepo;
	private UserProfilesRepository userProfRepo;

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
	public boolean checkLoginCred(String email, String pass) {
		if( this.authRepo.exists(email) ) {
			return pass.equals(this.authRepo.findOne(email).getPassword());
		};
		return false;
	}
}
