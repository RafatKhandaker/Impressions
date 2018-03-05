package com.blackjack.Model;

import java.sql.Date;

import javax.validation.constraints.Null;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.blackjack.Contracts.IPicture;

@Document(collection = "Pictures")
public class Picture implements IPicture{
	
	@Id
	private String email;
	private String image;
	private boolean isDefault;
	private Date date;
	
	@Null
	private String detail;
	
	
	public Picture(String email, String image, boolean isDefault, Date date) {
		this.email = email;
		this.image = image;
		this.isDefault = isDefault;
		this.date = date;
	}

	@Override
	public String getEmail() {
		return this.email;
	}

	@Override
	public String getImage() {
		return this.image;
	}

	@Override
	public boolean isDefault() {
		return this.isDefault;
	}
	
	public Date getDate() {
		return this.date;
	}
}
