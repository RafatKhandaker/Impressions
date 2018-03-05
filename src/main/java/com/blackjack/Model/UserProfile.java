package com.blackjack.Model;

import java.sql.Date;
import java.util.List;
import java.util.Queue;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blackjack.Contracts.IProfile;

@Document(collection = "UserProfiles")
public class UserProfile implements IProfile{
	
	@Id
	private String email;
	private Queue<Picture> pictures;
	private String firstName;
	private String lastName;
	private int zipcode;
	private List<Double> geoLocation;
	private String summary;
	private Survey<Object> survey;
	private List<Comments> anonComments;
	private Date lastOnline;
	private boolean isActive;
	
	public UserProfile( 
			String email, 
			Queue<Picture> pictures,
			String firstName, 
			String lastName, 
			int zipcode, 
			List<Double> geoLocation, 
			String summary, 
			Survey<Object> survey, 
			List<Comments> anonComments, 
			Date lastOnline,
			boolean isActive
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
		this.lastOnline = lastOnline;
		this.isActive = isActive;
	}
	
	public String email() { 
		return this.email; 
		}
	
	public String firstName() { 
		return this.firstName; 
		}
	
	public String lastName() { 
		return this.lastName; 
		}
	
	public int zipcode() { 
		return this.zipcode; 
		}
	
	public List<Double> geoLocation() { 
		return this.geoLocation; 
		}
	
	public String summary() { 
		return this.summary; 
		}
	
	public Survey<Object> survey() { 
		return this.survey; 
		}
	
	public List<Comments> anonComments() { 
		return this.anonComments; 
		}

	public Date lastOnline() { 
		return this.lastOnline; 
		} 
	
	public boolean isActive() { 
		return this.isActive; 
		}

	@Override
	public Queue<Picture> pictures() { 
		return this.pictures; 
		}

}
