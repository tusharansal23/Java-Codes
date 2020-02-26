package com.nagarro.hibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.Entity.Entity;

public class HibernateUtil {
	
	public static Session getSession() {
		Configuration con = new
				  Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Entity.
				  class); 
		SessionFactory sft = con.buildSessionFactory();
		Session sc = sft.openSession();
		return sc;
	}


}
