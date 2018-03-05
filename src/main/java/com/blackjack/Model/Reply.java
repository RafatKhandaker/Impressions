package com.blackjack.Model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import com.blackjack.Contracts.IResponse;

@Document(collection = "ReplyChain")
public class Reply implements IResponse{
	
	@Id
	private String Id;
	private String email;
	@Indexed(direction = IndexDirection.DESCENDING)
	private Date timeStamp;
	private String message;
	private List<Reply> replies;
	
	public Reply() {}
	
	public Reply( String email, Date timeStamp, String message, List<Reply> replies) {
		this.email = email;
		this.timeStamp = timeStamp;
		this.message = message;
		this.replies = replies;
	}
	
	public Date timeStamp() {
		return this.timeStamp;
	}

	public String message() {
		return this.message;
	}
	
	public List<Reply> replies(){ return this.replies; }
	public String email() { return this.email; } 
	
		public void setTimeStamp(Date timeStamp) { this.timeStamp = timeStamp; }
		
		public void setMessage(String message) { this.message = message; }
		
		public void setReplies(List<Reply> replies) { this.replies = replies; }

		
	
	

}
