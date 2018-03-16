package com.blackjack.Contracts;

import java.util.List;
import java.util.Queue;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import com.blackjack.Model.Comments;
import com.blackjack.Model.Picture;
import com.blackjack.Model.Survey;

public interface IProfile {
	
	 @NotNull
	 public String email();

	 @Null
	 public Queue<Picture> pictures();
	 
	 @NotNull
	 public String firstName();
	
	 @NotNull
	 public String lastName();
	 	
	 @NotNull
	 public int zipcode();
	 
	 @Null
	 public Double[] geoLocation();
	 
	 public String summary();
	 
	 public Survey<Object> survey();
	 
	 public List<Comments> anonComments();	
	 
}
