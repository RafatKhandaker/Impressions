package com.blackjack.Model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.blackjack.Contracts.IAuthentication;

@SuppressWarnings("serial")
@Document(collection = "Authentication")
public class Authentication implements IAuthentication, UserDetails{

	@Id
	private String id;
	private String email;
	private String password;
	private boolean isActive;
	private Timestamp dateCreated;
	private Timestamp lastLogin;
	private List<GrantedAuthority> grantedAuthorities;
	
	
	public Authentication() {};
	
	public Authentication(
			String email, 
			String password, 
			boolean isActive, 
			String[] authorities
			) {
		
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	//	this.lastLogin = new Timestamp(System.currentTimeMillis());
		this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
	}
	
	public Authentication(String email, String password, String[] authorities) {
		this.email = email;
		this.password = password;
		this.grantedAuthorities = AuthorityUtils.createAuthorityList(authorities);
	}
	
	public Authentication(String email, String password, boolean isActive) {
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}
	
	@Override
	public boolean isActive() {
		return this.isActive;
	}
	
	@Override
	public Timestamp dateCreated() {
		return this.dateCreated;
	}

	@Override
	public Timestamp lastLogin() {
		// TODO Auto-generated method stub
		return this.lastLogin;
	}
	
	@Override
	public String getUsername() {
		return this.email;
	}
	
	@Override
	public String getPassword() {
		return this.password;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return this.grantedAuthorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
