package com.busecnky.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.busecnky.entity.Admin;
import com.busecnky.entity.Category;
import com.busecnky.entity.Customer;
import com.busecnky.entity.Product;
import com.busecnky.entity.ProductEvaluate;





public class HibernateUtils {

	
	private static final SessionFactory SESSION_FACTORY = sessionFactoryHibernate();

	private static SessionFactory sessionFactoryHibernate() {

		try {
			Configuration configuration = new Configuration();

			configuration.addAnnotatedClass(Admin.class);
			configuration.addAnnotatedClass(Category.class);
			configuration.addAnnotatedClass(Customer.class);
			configuration.addAnnotatedClass(Product.class);
			configuration.addAnnotatedClass(ProductEvaluate.class);

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
