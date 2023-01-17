package com.busecnky.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.busecnky.entity.Customer;
import com.busecnky.service.CustomerService;
import com.busecnky.utils.BAUtils;


public class CustomerController {
	
	CustomerService customerService;
	
	public CustomerController() {
		customerService = new CustomerService();
	}

	public List<Customer> findByEmail(String email) {
		return customerService.findByEmail(email);
	}

	public void listAll() {
		customerService.listAll();
	}

	public void create() {
		String firstName = BAUtils.readString("Please enter your name: ");
		String lastName = BAUtils.readString("Please enter your last name: ");
		String identity = BAUtils.readString("Please enter your identity number: ");
		String email = BAUtils.readString("Please enter your email: ");
		String password = BAUtils.readString("Please enter password: ");
		
		if(StringUtils.isNumeric(identity)) {
			if(identity.length() == 11) {
				if(email.contains("@")) {
					Customer customer = customerService.listAll2().stream().filter(c -> c.getEmail().equals(email)).findAny().orElse(null);
						if(customer == null) {
							customer = new Customer(firstName, lastName, email, password, identity);	
							customerService.create(customer);
						}else {
							System.out.println("This email already taken.");
						}	
					}else {
						System.out.println("Email should have @ sign.");
					}
			}else {
				System.out.println("Identity number must be 11 digits");
			}
			
		}else {
			System.out.println("You should enter number for identity.");
		}
		
		
		
		
		
	}

}
