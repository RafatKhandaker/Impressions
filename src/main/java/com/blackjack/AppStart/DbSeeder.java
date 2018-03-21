package com.blackjack.AppStart;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blackjack.Model.Authentication;
import com.blackjack.Model.Question;
import com.blackjack.Repository.AuthenticationRepository;
import com.blackjack.Repository.ProfilesRepository;
import com.blackjack.Repository.QuestionsRepository;
@SuppressWarnings("unused")

@Component
public class DbSeeder implements CommandLineRunner {
	
	@Autowired
	private QuestionsRepository qRepository;
	@Autowired
	private AuthenticationRepository authRepository;
	@Autowired
	private ProfilesRepository profRepo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// reset database on start
//		this.qRepository.deleteAll();
//		this.authRepository.deleteAll();
//		this.profRepo.deleteAll()
//		
//		//Add Object to DB
//		populateQuestions();
//		populateAuthentications();
		
	}
	
	private void populateQuestions() {
		List<Question<Object>> testQuestions = Arrays.asList( 
				new Question<Object>(
						"test@email.com","1","Test-Survey","Is The Sky Blue?",100.0
				)
		);
		this.qRepository.save(testQuestions);
	}
	
	private void populateAuthentications() {		
		List<Authentication> testAuthentication = Arrays.asList(
				new Authentication(
						"test@email.com", "testpassword" , false, new String[] {"USER", "ADMIN"}
						)
				);
		this.authRepository.save(testAuthentication);
;	}
}
