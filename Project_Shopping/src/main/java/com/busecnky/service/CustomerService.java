package com.busecnky.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.busecnky.entity.Customer;
import com.busecnky.repository.CustomerDao;

public class CustomerService implements IService<Customer> {

private CustomerDao customerDao;
	
	public CustomerService() {
		this.customerDao = new CustomerDao();
	}
	
	@Override
	public void create(Customer entity) {
		customerDao.create(entity);
	}

	@Override
	public void delete(long id) {
		customerDao.delete(id);
	}

	@Override
	public void update(long id, Customer entity) {
		customerDao.update(id, entity);
	}

	@Override
	public List<Customer> listAll() {
		return customerDao.listAll();
	}

	@Override
	public Customer find(long id) {
		Customer customer = customerDao.find(id);
		return customer;
	}

	public List<Customer> findByEmail(String email) {
		return customerDao.findByEmail(email);
	}

	public void update(long id, Optional<Customer> customer) {
		customerDao.update(id, customer);
		
	}

	public Collection<Customer> listAll2() {
		return customerDao.listAll2();
	}
	
	
	
	
}
