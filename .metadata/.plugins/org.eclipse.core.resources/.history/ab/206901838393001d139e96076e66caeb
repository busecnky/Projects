package com.december30.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class Admin extends User {

	@Id
	@GeneratedValue
	private long id;
	
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private EUserType userType = EUserType.ADMIN;
	
	
	

	public Admin(String username, String password) {
		super(username,password);
	}
	
	public Admin() {
		super();
	}
	
	
}
