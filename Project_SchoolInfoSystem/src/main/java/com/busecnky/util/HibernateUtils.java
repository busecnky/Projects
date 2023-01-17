package com.busecnky.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.busecnky.entity.Contact;
import com.busecnky.entity.Student;




public class HibernateUtils {

	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Contact.class);


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
