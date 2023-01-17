package com.busecnky.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.busecnky.entity.ProductEvaluate;

public class ProductEvaluateDao implements ICrud<ProductEvaluate>{

	@Override
	public void create(ProductEvaluate entity) {
		Session session = null;
		
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ProductEvaluate data is added to DB");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding ProductEvaluate to DB");
		}finally {
			session.close();
		}
			
		
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		
		try {
			ProductEvaluate deleteProductEvaluate = find(id);
			if(deleteProductEvaluate != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteProductEvaluate);
				session.getTransaction().commit();
				System.out.println("ProductEvaluate data is deleted from DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting ProductEvaluate from DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, ProductEvaluate entity) {
		Session session = null;
		
		try {
			ProductEvaluate productEvaluate = find(id);
			if(productEvaluate != null) {
				productEvaluate.setId(entity.getId());
				productEvaluate.setComment(entity.getComment());
				productEvaluate.setPoint(entity.getPoint());
				productEvaluate.setCustomer(entity.getCustomer());
				productEvaluate.setProduct(entity.getProduct());
				
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(productEvaluate);
				session.getTransaction().commit();
				System.out.println("ProductEvaluate data is updated");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating ProductEvaluate");
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<ProductEvaluate> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select productEvaluate from ProductEvaluate as productEvaluate";
		TypedQuery<ProductEvaluate> typedQuery = session.createQuery (query, ProductEvaluate.class);
		List<ProductEvaluate> productEvaluateList = typedQuery.getResultList();
		
		return productEvaluateList;
	}

	@Override
	public ProductEvaluate find(long id) {
		Session session = dataBaseConnectionHibernate();
		ProductEvaluate productEvaluate;
		try {
			productEvaluate = session.find(ProductEvaluate.class, id);
			if(productEvaluate!= null) {
				System.out.println("ProductEvaluate found --> " + productEvaluate.getId() + " " + productEvaluate.getComment());
				return productEvaluate;
			}else {
				System.out.println("ProductEvaluate not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while finding ProductEvaluate");
		}
		return null;
	}


}
