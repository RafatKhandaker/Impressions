package com.blackjack.Model;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Queue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.blackjack.Contracts.IProfile;

@Document(collection = "UserProfiles")
public class UserProfile implements IProfile{
	
	@Id
	private String email;
	private Queue<Picture> pictures;
	private String firstName;
	private String lastName;
	private int zipcode;
	private Double[] geoLocation;
	private String summary;
	private Survey<Object> survey;
	private List<Comments> anonComments;
	
	@Indexed
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Instant lastOnline;
	
	private String[] interests;
	
	public UserProfile() {}
	
	public UserProfile( 
			String email, 
			String firstName, 
			String lastName, 
			int zipcode, 
			String summary, 
			String[] interests
			) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipcode = zipcode;
		this.summary = summary;
		this.lastOnline = new Timestamp(System.currentTimeMillis()).toInstant();		
		this.interests = interests;
	}
	
	public UserProfile( 
			String email, 
			Queue<Picture> pictures,
			String firstName, 
			String lastName, 
			int zipcode, 
			Double[] geoLocation, 
			String summary, 
			Survey<Object> survey, 
			List<Comments> anonComments
			) {
		this.email = email;
		this.pictures = pictures;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zipcode = zipcode;
		this.geoLocation = geoLocation;
		this.summary = summary;
		this.survey = survey;
		this.anonComments = anonComments;
		this.lastOnline = new Timestamp(System.currentTimeMillis()).toInstant();
	}
	
	public String getemail() { 
		return this.email; 
	}
	
	public String getfirstName() { 
		return this.firstName; 
	}
	
	public String getlastName() { 
		return this.lastName; 
	}
	
	public int getzipcode() { 
		return this.zipcode; 
	}
	
	public Double[] getgeoLocation() { 
		return this.geoLocation; 
	}
	
	public String getsummary() { 
		return this.summary; 
	}
	
	public Survey<Object> getsurvey() { 
		return this.survey; 
	}
	
	public List<Comments> getanonComments() { 
		return this.anonComments; 
	}

	public Instant getlastOnline() { 
		return this.lastOnline; 
	} 
	
	public String[] getInterests() {
		return this.interests;
	}

	@Override
	public Queue<Picture> getpictures() { 
		return this.pictures; 
		}

}
