package com.busecnky.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.busecnky.entity.Category;

public class CategoryDao implements ICrud<Category>{

	@Override
	public void create(Category entity) {
		Session session = null;
		
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Category data is added to DB");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Category to DB");
		}finally {
			session.close();
		}
			
		
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		
		try {
			Category deleteCategory = find(id);
			if(deleteCategory != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteCategory);
				session.getTransaction().commit();
				System.out.println("Category data is deleting from DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Category from DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, Category entity) {
		Session session = null;
		
		try {
			Category category = find(id);
			if(category != null) {
				category.setId(entity.getId());
				category.setName(entity.getName());
				category.setProducts(entity.getProducts());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(category);
				session.getTransaction().commit();
				System.out.println("Category data is added to DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Category");
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Category> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select category from Category as category";
		TypedQuery<Category> typedQuery = session.createQuery (query, Category.class);
		List<Category> categoryList = typedQuery.getResultList();
		
		for (int i = 0; i < categoryList.size(); i++) {
			System.out.println("Category ID: " + categoryList.get(i).getId() + " Category Name: " + categoryList.get(i).getName() +
					" Products: " + categoryList.get(i).getProducts().size());
		}
		
		return categoryList;
	}

	@Override
	public Category find(long id) {
		Session session = dataBaseConnectionHibernate();
		Category category;
		try {
			category = session.find(Category.class, id);
			if(category!= null) {
				System.out.println("Category found --> " + category);
				return category;
			}else {
				System.out.println("Category not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Category to DB");
		}
		return null;
	}




}
