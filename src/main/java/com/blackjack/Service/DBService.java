package com.blackjack.Service;

import java.util.Arrays;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.blackjack.Contracts.IAuthentication;
import com.blackjack.Contracts.IDBService;
import com.blackjack.Contracts.IForm;
import com.blackjack.Contracts.ILogger;
import com.blackjack.Contracts.IProfile;
import com.blackjack.Contracts.IResponse;
import com.blackjack.Contracts.ISurvey;
import com.blackjack.Model.Authentication;
import com.blackjack.Model.ErrorLog;
import com.blackjack.Model.RegisterForm;
import com.blackjack.Model.UserProfile;
import com.blackjack.Repository.AuthenticationRepository;
import com.blackjack.Repository.CommentsRepository;
import com.blackjack.Repository.QuestionsRepository;
import com.blackjack.Repository.RepliesRepository;
import com.blackjack.Repository.SurveysRepository;
import com.blackjack.Repository.ProfilesRepository;

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
	private ProfilesRepository profRepo;
	
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
	public boolean checkAccountExist(String email) {
		
		try { return  ( this.authRepo.findByEmail(email) != null )? true: false; }
		catch(Exception e) { eLog.insertError( new ErrorLog(email , e) ); }
		return false;
	}
	
	@Override
	public boolean checkLoginCred(String email, String pass) {
		
		try { return pass.equals( this.authRepo.findByEmail(email).getPassword() ); }
		catch(Exception e) { eLog.insertError( new ErrorLog(email , pass, e) ); }
		return false;
	}

	public void insertNewAccount(String email, String pass) {
		List<Authentication> newAuthentication = Arrays.asList(
				new Authentication(
						email, pass, false, new String[]{ "USER" }
						)
				);
		try { this.authRepo.save(newAuthentication); }
		catch(Exception e ) { eLog.insertError(new ErrorLog( email, pass, e) ); }		
	}

	@Override
	public void insertNewProfile(String email, IForm proForm) {
		List<UserProfile> newProfiles = Arrays.asList(
				new UserProfile( 
						email, 
						proForm.gettxtFName(), 
						proForm.gettxtLName(),
						proForm.getzipcode(), 
						proForm.gettxtSummaryField(),	 
						proForm.getmultiCheckInterests() 
						)
				);
		try { this.profRepo.save(newProfiles); }
		catch(Exception e) { eLog.insertError(new ErrorLog( email, e)); }
	}

}
