package com.busecnky.repository;

import java.util.Collection;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.busecnky.entity.Category;
import com.busecnky.entity.Product;

public class ProductDao implements ICrud<Product>{

	@Override
	public void create(Product entity) {
		Session session = null;
		
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Product data is added to DB");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Product to DB");
		}finally {
			session.close();
		}
			
		
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		
		try {
			Product deleteProduct = find(id);
			if(deleteProduct != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteProduct);
				session.getTransaction().commit();
				System.out.println("Product data is deleted from DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Product from DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, Product entity) {
		Session session = null;
		
		try {
			Product product = find(id);
			if(product != null) {
				product.setId(entity.getId());
				product.setName(entity.getName());
				product.setPrice(entity.getPrice());
				product.setStock(entity.getStock());
				product.setProductEvaluates(entity.getProductEvaluates());
				product.setCategory(entity.getCategory());
				product.setCustomers(entity.getCustomers());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(product);
				session.getTransaction().commit();
				System.out.println("Product data is updated");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Product");
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Product> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select product from Product as product";
		TypedQuery<Product> typedQuery = session.createQuery (query, Product.class);
		List<Product> productList = typedQuery.getResultList();

		for (int i = 0; i < productList.size(); i++) {
			System.out.println("Product ID: " + productList.get(i).getId() + " Product Name: " + productList.get(i).getName() + " Price: " + productList.get(i).getPrice() +
					"Stock: " + productList.get(i).getStock() + " Category: " + productList.get(i).getCategory());
		}
		return productList;
	}

	@Override
	public Product find(long id) {
		Session session = dataBaseConnectionHibernate();
		Product product;
		try {
			product = session.find(Product.class, id);
			if(product!= null) {
				System.out.println("Product found --> " + product.getName());
				return product;
			}else {
				System.out.println("Product not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while finding Product");
		}
		return null;
	}

	public List<Product> listAll2() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select product from Product as product";
		TypedQuery<Product> typedQuery = session.createQuery (query, Product.class);
		List<Product> productList = typedQuery.getResultList();

		return productList;
	}




}
