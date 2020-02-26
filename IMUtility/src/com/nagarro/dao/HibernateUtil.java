package com.nagarro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.model.Image;
import com.nagarro.model.User;

public class HibernateUtil {
	public static Session getSession() {
		Configuration con = new
				  Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.
				  class).addAnnotatedClass(Image.
						  class); 
		SessionFactory sft = con.buildSessionFactory();
		Session sc = sft.openSession();
		return sc;
	}


}
