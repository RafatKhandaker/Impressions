package com.blackjack.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import org.springframework.data.annotation.Id;
import com.blackjack.Contracts.ISurvey;

@Document(collection = "Surveys")
public class Survey<T> implements ISurvey<Object>{
 
	@Id
	private String id;
	private String email;
	private String surveyName;
	private List<Question<Object>> questions;
	
	public Survey(String email, String surveyName, List<Question<Object>> questions) {
		this.email = email;
		this.surveyName = surveyName;
		this.questions = questions;
	}

	@Override
	public List<Question<Object>> getQuestions() {
		return this.questions;
	}
	
	public String getEmail() { return this.email; }
	public String getSurveyName() { return this.surveyName; }

}
