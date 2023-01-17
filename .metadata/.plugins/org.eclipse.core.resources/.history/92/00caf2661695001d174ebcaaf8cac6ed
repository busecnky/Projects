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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	
	private double price;
	
	private int stock;
	
	@ManyToMany(mappedBy = "products")
	private List<Customer> customers;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Category category;

	@OneToMany(mappedBy = "product")
	private List<ProductEvaluate> productEvaluates;

	public Product(String name, double price, int stock, List<Customer> customers, Category category,
			List<ProductEvaluate> productEvaluates) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.customers = customers;
		this.category = category;
		this.productEvaluates = productEvaluates;
	}

	
	public Product(String name, double price, int stock, Category category) {
		super();
		this.name = name;
		this.price = price;
		this.stock = stock;
		this.category = category;
	}
	
	public Product() {
		super();
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<ProductEvaluate> getProductEvaluates() {
		return productEvaluates;
	}


	public void setProductEvaluates(List<ProductEvaluate> productEvaluates) {
		this.productEvaluates = productEvaluates;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", stock=" + stock + ", customers="
				+ customers.size() + ", category=" + category + ", productEvaluates=" + productEvaluates.size() + "]";
	}
	
	
}
