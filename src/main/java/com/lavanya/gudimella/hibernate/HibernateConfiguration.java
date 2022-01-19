package com.lavanya.gudimella.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {
	
	private static Configuration configuration;
	private static SessionFactory sessionfactory;
	
	static {
		configuration = new Configuration();
		sessionfactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	/**
	 * get the session factory to store the student values into the database
	 * assign it a static method later - class level
	 * @return sessionfactory
	 */
	public static SessionFactory getSessionFactory() {
		return sessionfactory;
	}
}
