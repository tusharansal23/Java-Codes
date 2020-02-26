package com.nagarro.hibernateUtil;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.entity.EndUser;

public class HibernateUtil {

	public Session getSession() {
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(EndUser.class);
		SessionFactory sft = con.buildSessionFactory();
		Session sc = sft.openSession();
		return sc;
	}

}
