package com.blackjack.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.blackjack.Contracts.IAuthentication;
import com.blackjack.Contracts.IDBService;
import com.blackjack.Contracts.ILogger;
import com.blackjack.Contracts.IProfile;
import com.blackjack.Contracts.IResponse;
import com.blackjack.Contracts.ISurvey;
import com.blackjack.Model.Authentication;
import com.blackjack.Model.ErrorLog;
import com.blackjack.Repository.AuthenticationRepository;
import com.blackjack.Repository.CommentsRepository;
import com.blackjack.Repository.QuestionsRepository;
import com.blackjack.Repository.RepliesRepository;
import com.blackjack.Repository.SurveysRepository;
import com.blackjack.Repository.UserProfilesRepository;

@SuppressWarnings("unused")
@Component
public class DBService<T> implements IDBService 	{

	@Autowired
	private AuthenticationRepository authRepo;
	@Autowired
	private CommentsRepository commRepo;
	@Autowired
	private QuestionsRepository qRepo;
	@Autowired
	private RepliesRepository repRepo;
	@Autowired
	private SurveysRepository survRepo;
	@Autowired
	private UserProfilesRepository userProfRepo;
	
	@Autowired
	private ILogger eLog;
	
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
		return this.authentication.isActive();
	}
	
	@Override
	public Authentication pullUserAccount(String email) {
		return this.authRepo.findByEmail(email);
	}

	@Override
	public boolean checkLoginCred(String email, String pass) {
		
		try { return pass.equals( this.authRepo.findByEmail(email).getPassword()); }
		catch(Exception e) { eLog.insertError( new ErrorLog(email , pass, e) ); }
		
		return false;
	}

	public void insertNewAccount(String email, String pass) {
		List<Authentication> newAuthentication = Arrays.asList(
				new Authentication(
						email, pass, false
						)
				);
		try { this.authRepo.save(newAuthentication); }
		catch(Exception e ) { eLog.insertError(new ErrorLog( email, pass, e) ); }		
	}

}
