package com.busecnky.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Admin(long id, String firstName, String lastName, String email) {
		super(firstName, lastName, email);
		this.id = id;
	}

	public Admin() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getEmail()=" + getEmail() + "]";
	}
	
	


	
	
	
}
