package com.blackjack.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.*;

@Document(collection = "Questions")
public class Question<T> {
	
	@Id
	private String email;
	private String surveyId;
	private String surveyName;
	private String question;
	private double score;
	
	public Question(String email, String surveyId, String surveyName, String question, Double score){
		this.email = email;
		this.surveyId = surveyId;
		this.surveyName = surveyName;
		this.question = question;
		this.score = score;
	}
	
	public void setSurveyId(String surveyId) { this.surveyId = surveyId; }
	public void setSurveyName(String surveyName) { this.surveyName = surveyName; }
	public void setQuestion(String question) { this.question = question;}
	public void setScore(Double score) { this.score = score; }
	
	public String getSurveyId() { return this.surveyId; }
	public String getSurveyName() { return this.surveyName; }
	public String getQuestion() { return this.question; }
	public double getScore() { return this.score; }
	
	
}
