package com.busecnky.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;
import javax.persistence.TypedQuery;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Customer;

public class CustomerDao implements ICrud<Customer>{

	@Override
	public void create(Customer entity) {
		Session session = null;
		
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Customer data is added to DB");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Customer to DB");
		}finally {
			session.close();
		}
			
		
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		
		try {
			Customer deleteCustomer = find(id);
			if(deleteCustomer != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteCustomer);
				session.getTransaction().commit();
				System.out.println("Customer data is deleted from DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Customer from DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, Customer entity) {
		Session session = null;
		
		try {
			Customer customer = find(id);
			if(customer != null) {
				customer.setId(entity.getId());
				customer.setFirstName(entity.getFirstName());
				customer.setLastName(entity.getLastName());
				customer.setEmail(entity.getEmail());
				customer.setIdentity(entity.getIdentity());
				customer.setPassword(entity.getPassword());
				customer.setProducts(entity.getProducts());
				customer.setProductEvaluates(entity.getProductEvaluates());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(customer);
				session.getTransaction().commit();
				System.out.println("Customer data is updated");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Customer");
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Customer> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select customer from Customer as customer";
		TypedQuery<Customer> typedQuery = session.createQuery (query, Customer.class);
		List<Customer> customerList = typedQuery.getResultList();
		for (int i = 0; i < customerList.size(); i++) {
			System.out.println("Customer id= " + customerList.get(i).getId() +  ", Identity=" + customerList.get(i).getIdentity() 
					+ ", FirstName= " + customerList.get(i).getFirstName() + ", LastName= " + customerList.get(i).getLastName() 
					+ ", Email= " + customerList.get(i).getEmail() + ", Password= " + customerList.get(i).getPassword());
		}
		return customerList;
	}

	public List<Customer> listAll2() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select customer from Customer as customer";
		TypedQuery<Customer> typedQuery = session.createQuery (query, Customer.class);
		List<Customer> customerList = typedQuery.getResultList();
		
		return customerList;
	}
	@Override
	public Customer find(long id) {
		Session session = dataBaseConnectionHibernate();
		Customer customer;
		try {
			customer = session.find(Customer.class, id);
			if(customer!= null) {
				System.out.println("Customer found --> " + customer.getFirstName() + " " + customer.getLastName());
				return customer;
			}else {
				System.out.println("Customer not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while finding Customer");
		}
		return null;
	}


	public List<Customer> findByEmail(String email) {
		Transaction transaction = null;
		Session session = dataBaseConnectionHibernate();
		List<Customer> customer = null;
		String hql = "select user from Customer as user where user.email = :key ";
		Query query = session.createQuery(hql);
		query.setParameter("key", email);

		try {
			transaction = session.beginTransaction();
			customer = query.getResultList();
			transaction.commit();
			session.close();
			
		} catch (Exception e) {
			if(transaction != null) {
				transaction.rollback();
			}
		}
		return customer;
	}

	public void update(long id, Optional<Customer> customer) {
	Session session = null;
		
		try {
			Customer cust = find(id);
			if(cust != null) {
				cust.setId(customer.get().getId());
				cust.setFirstName(customer.get().getFirstName());
				cust.setLastName(customer.get().getLastName());
				cust.setEmail(customer.get().getEmail());
				cust.setIdentity(customer.get().getIdentity());
				cust.setPassword(customer.get().getPassword());
				cust.setProducts(customer.get().getProducts());
				
				cust.setProductEvaluates(customer.get().getProductEvaluates());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(cust);
				session.getTransaction().commit();
				System.out.println("Customer data is updated");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Customer");
		}finally {
			session.close();
		}
		
	}


}
