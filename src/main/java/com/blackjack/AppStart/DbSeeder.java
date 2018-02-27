package com.blackjack.AppStart;

import java.util.Arrays;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.blackjack.Model.Question;
import com.blackjack.Repository.QuestionsRepository;

@Component
public class DbSeeder implements CommandLineRunner {

	private QuestionsRepository qRepository;
	
	public DbSeeder(QuestionsRepository qRepository) { this.qRepository = qRepository; }
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Question<Object> testQuestion = new Question<Object>(
				"1",
				"Test-Survey",
				"Is The Sky Blue?",
				100.0
				);
		
		// reset database on start
		this.qRepository.deleteAll();
		
		//Add Object to DB
		List<Question<Object>> testQuestions = Arrays.asList(testQuestion);
		this.qRepository.save(testQuestions);
		
	}

}
