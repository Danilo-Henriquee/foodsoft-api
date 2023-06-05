package com.henrique.workshopmongo.domain;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Permission implements GrantedAuthority {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String authority;
	
	private List<User> users;
	
	public Permission() {}
	
	public Permission(String id, String authority) {
		this.id = id;
		this.authority = authority;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String getAuthority() {
		return null;
	}

}
