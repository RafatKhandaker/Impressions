package com.blackjack.Contracts;

import java.util.List;

import com.blackjack.Model.Question;

public interface ISurvey<T> {
	
	 public List<Question<Object>> getQuestions();

}
