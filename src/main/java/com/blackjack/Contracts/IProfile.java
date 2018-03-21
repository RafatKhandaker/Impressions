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
	 public String getemail();

	 @Null
	 public Queue<Picture> getpictures();
	 
	 @NotNull
	 public String getfirstName();
	
	 @NotNull
	 public String getlastName();
	 	
	 @NotNull
	 public int getzipcode();
	 
	 @Null
	 public Double[] getgeoLocation();
	 
	 public String getsummary();
	 
	 public Survey<Object> getsurvey();
	 
	 public List<Comments> getanonComments();	
	 
}
