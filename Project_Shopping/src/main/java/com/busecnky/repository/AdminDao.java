package com.busecnky.repository;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.busecnky.entity.Admin;

public class AdminDao implements ICrud<Admin>{

	@Override
	public void create(Admin entity) {
		Session session = null;
		
		try {
			session = dataBaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("Admin data is added to DB");
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Admin to DB");
		}finally {
			session.close();
		}
			
		
		
	}

	@Override
	public void delete(long id) {
		Session session = null;
		
		try {
			Admin deleteAdmin = find(id);
			if(deleteAdmin != null) {
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(deleteAdmin);
				session.getTransaction().commit();
				System.out.println("Admin data is deleted from DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while deleting Admin from DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void update(long id, Admin entity) {
		Session session = null;
		
		try {
			Admin admin = find(id);
			if(admin != null) {
				admin.setId(entity.getId());
				admin.setFirstName(entity.getFirstName());
				admin.setLastName(entity.getLastName());
				admin.setEmail(entity.getEmail());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(admin);
				session.getTransaction().commit();
				System.out.println("Admin data is updated");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while updating Admin");
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Admin> listAll() {
		Session session = null;
		session = dataBaseConnectionHibernate();
		String query = "select admin from Admin as admin";
		TypedQuery<Admin> typedQuery = session.createQuery (query, Admin.class);
		List<Admin> adminList = typedQuery.getResultList();
		
		return adminList;
	}

	@Override
	public Admin find(long id) {
		Session session = dataBaseConnectionHibernate();
		Admin admin;
		try {
			admin = session.find(Admin.class, id);
			if(admin!= null) {
				System.out.println("Admin found --> " + admin.getFirstName() + " " + admin.getLastName());
				return admin;
			}else {
				System.out.println("Admin not found");
				return null;
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while finding Admin");
		}
		return null;
	}




}
