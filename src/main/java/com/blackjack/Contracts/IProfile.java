package com.blackjack.Contracts;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.blackjack.Model.Comments;
import com.blackjack.Model.Survey;

public interface IProfile {
	
	 @NotNull
	 public String firstName();
	
	 @NotNull
	 public String lastName();
	 
	 @NotNull
	 public String email();
	
	 @NotNull
	 public int zipcode();
	 
	 @Null
	 public List<Double> geoLocation();
	 
	 public String summary();
	 
	 public Survey<Object> survey();
	 
	 public List<Comments> anonComments();
	 
	// public List<links>
	 
	 
	 
	
	
	 
}
