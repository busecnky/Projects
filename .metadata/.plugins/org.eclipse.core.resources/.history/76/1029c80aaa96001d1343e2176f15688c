package com.busecnky.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<Product> products;


	
	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {
		super();;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category id= " + id + ", name= " + name + ", products= " + products.size() + "\n";
	}


	
	
	
}
