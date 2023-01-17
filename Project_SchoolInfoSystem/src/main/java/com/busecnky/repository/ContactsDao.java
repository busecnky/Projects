package com.busecnky.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.busecnky.entity.Contact;

public class ContactsDao implements ICrud<Contact>{

	@Override
	public void save(Contact t) {

		Transaction transaction = null;

		try (Session session = dataBaseConnectionHibernate()) {

			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			session.close();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();

			}
			System.out.println("Saved Error");
		}

	}

	@Override
	public void update(long id, Contact t) {
		Session session = null;
		
		try {
			Contact contacts = findById(id);
			if(contacts != null) {
				contacts.setId(t.getId());
				contacts.setPhone1(t.getPhone1());
				contacts.setPhone2(t.getPhone2());
				contacts.setAddress1(t.getAddress1());
				contacts.setAddress2(t.getAddress2());
				
				session = dataBaseConnectionHibernate();
				session.getTransaction().begin();
				session.update(contacts);
				session.getTransaction().commit();
				System.out.println("Contacts data is added to DB");
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Some problem occured while adding Contacts to DB");
		}finally {
			session.close();
		}
		
	}

	@Override
	public void delete(long id) {

		Transaction transaction = null;

		try (Session session = dataBaseConnectionHibernate()) {
			Contact contacts = findById(id);
			if (contacts != null) {

				transaction = session.beginTransaction();
				session.delete(contacts);
				transaction.commit();
				System.out.println("Contacts deleted---> " + contacts.getAddress1());
			} else {
				System.out.println("Not found Student ID");
			}

		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public List<Contact> findAll() {
		Transaction transaction = null;
		List<Contact> contactss = null;
		try (Session session = dataBaseConnectionHibernate()) {
			transaction = session.beginTransaction();
			contactss = session.createQuery("from Contacts", Contact.class).list();
			transaction.commit();

			for (Contact contacts : contactss) {
				System.out.println(contacts);
			}
		}
		return contactss;
	}
	


	@Override
	public Contact findById(long id) {

		Session session = dataBaseConnectionHibernate();

		Contact contacts;

		try {
			contacts = session.find(Contact.class, id);
			if (contacts != null) {
				System.out.println("Contacts found -->" + contacts);
				return contacts;
			} else {
				System.out.println("Error! Check ID");
			}
		} catch (Exception e) {
			System.out.println("Something wrong");
		} finally {
			session.close();
		}

		return null;
	}

}



