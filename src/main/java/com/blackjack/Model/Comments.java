package com.blackjack.Model;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blackjack.Contracts.IResponse;

@Document(collection = "Comments")
public class Comments implements IResponse{
		
	@Id
	private String id;
	private String email;
	
	@Indexed(direction = IndexDirection.DESCENDING)
	private Date timeStamp;
	
	private String message;
	private List<Reply> replies;
	
	
	public Comments(String email, Date timeStamp, String message, List<Reply> replies) {
		this.email = email;
		this.timeStamp =  timeStamp;
		this.message = message;
		this.replies = replies;
	}
	
	public Date timeStamp() {
		return this.timeStamp;
	}

	public String message() {
		return this.message;
	}
	
	public String getEmail() { return this.email; }
	
	// Model Specific to class 
	public List<Reply> replies(){ return this.replies; }
	public void setEmail(String email) { this.email = email; }
	public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }	
	public void setMessage(String message) { this.message = message; } 
	public void setReplies(List<Reply> replies) { this.replies = replies; }

	public String Message() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
