package com.busecnky.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String password;
	
	private String identity;

	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Product> products;
	
	@OneToMany(mappedBy = "customer")
	private List<ProductEvaluate> productEvaluates;

	
	public Customer(String firstName, String lastName, String email, String password, String identity) {
		super(firstName, lastName, email);
		this.password = password;
		this.identity = identity;
	}



	public Customer(String firstName, String lastName, String email, long id, String password, String identity,
			List<Product> products, List<ProductEvaluate> productEvaluates) {
		super(firstName, lastName, email);
		this.id = id;
		this.password = password;
		this.identity = identity;
		this.products = products;
		this.productEvaluates = productEvaluates;
	}






	public Customer() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}



	public List<ProductEvaluate> getProductEvaluates() {
		return productEvaluates;
	}

	public void setProductEvaluates(List<ProductEvaluate> productEvaluates) {
		this.productEvaluates = productEvaluates;
	}



	@Override
	public String toString() {
		return "Customer id= " + id +  ", Identity=" + identity + ", FirstName= " + getFirstName() 
		+ ", LastName= " + getLastName() + ", Email= " + getEmail() + ", Password= " + password + "\n";
	}




	
	
	
}
