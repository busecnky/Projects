package com.december30.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.december30.entity.Admin;
import com.december30.entity.Author;
import com.december30.entity.Book;
import com.december30.entity.BookDetail;
import com.december30.entity.Student;



public class HibernateUtils {

	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Admin.class);
			configuration.addAnnotatedClass(Author.class);
			configuration.addAnnotatedClass(Book.class);
			configuration.addAnnotatedClass(BookDetail.class);
			configuration.addAnnotatedClass(Student.class);

			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();

			return factory;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
