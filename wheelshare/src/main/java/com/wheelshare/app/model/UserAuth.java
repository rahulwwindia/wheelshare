package com.wheelshare.app.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@Entity
@Table(name = "USER_AUTH")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserAuth{
	  
	@Id
	@Column(name = "USER_ID")
	private long userId;
	  
	@Column(name = "PASSWORD")
	private String password;
	
	public long getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


}
