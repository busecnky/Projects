package com.busecnky.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.busecnky.ShoppingApp;
import com.busecnky.controller.AdminController;
import com.busecnky.controller.CategoryController;
import com.busecnky.controller.CustomerController;
import com.busecnky.controller.ProductController;
import com.busecnky.controller.ProductEvaluateController;
import com.busecnky.entity.Customer;
import com.busecnky.entity.Product;



public class ShoppingMenu {

	
	AdminController adminController;
	CategoryController categoryController;
	CustomerController customerController;
	ProductController productController;
	ProductEvaluateController productEvaluateController;
	

	public ShoppingMenu() {
		super();
		this.adminController = new AdminController();
		this.categoryController = new CategoryController();
		this.customerController = new CustomerController();
		this.productController = new ProductController();
		this.productEvaluateController = new ProductEvaluateController();
	}
	
	
	public void menu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Admin");
		menuItems.put(2, "Customer");
		menuItems.put(3, "Exit");
		
		
		int key = BAUtils.menu(menuItems);
		switch (key) {
		case 1:
			adminMenu();
			break;
		case 2:
			customerMenu();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			break;
		}
	}
	
	private void adminMenu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Add Category");
		menuItems.put(2, "Add Product");
		menuItems.put(3, "List Costumers");
		menuItems.put(4, "Back to Menu");

		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			categoryController.create();
			adminMenu();
			break;
		case 2:
			productController.create();
			adminMenu();
			break;
		case 3:
			customerController.listAll();
			adminMenu();
			break;
		case 4:
			menu();
			break;
		default:
			break;
		}
	}
	
	private void customerMenu() {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Sign Up");
		menuItems.put(2, "Login");
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			customerController.create();
			customerMenu();
			break;
		case 2:
			customerLogin();
			customerMenu();
			break;
		default:
			break;
		}
	}
	
	private void customerManager(Customer customer) {
		HashMap<Integer,String> menuItems = new HashMap<>();
		menuItems.put(1, "Buy Products");
		menuItems.put(2, "Comment");
		menuItems.put(3, "List Products Almost Out of Stock");
		menuItems.put(4, "List All Products");
		menuItems.put(5, "List All Comments by Products");
		menuItems.put(6, "Log out");
		
		int key = BAUtils.menu(menuItems);
		
		switch (key) {
		case 1:
			productController.buyProduct(customer);
			customerManager(customer);
			break;
		case 2:
			productEvaluateController.comment(customer);
			customerManager(customer);
			break;
		case 3:
			productController.outOfStock();
			customerManager(customer);
			break;
		case 4:
			productController.listAll();
			customerManager(customer);
			break;
		case 5:
			productEvaluateController.commentListByProducts(customer);
			customerManager(customer);
			break;
		case 6:
			menu();
			break;	
		default:
			break;
		}
	}
	
	private void customerLogin() {
		String email = BAUtils.readString("Please enter your email: ");
		String password = BAUtils.readString("Please enter your password: ");
		
		List<Customer> customer = customerController.findByEmail(email);
	
		if(!(customer.isEmpty())) {
			if(customer.get(0).getPassword().equals(password)) {
				customerManager(customer.get(0));				
			}else {
				System.out.println("Check the password");
			}
			
		}else {
			System.out.println("Username is wrong!");
		}
	
	
	
	}
	
}
