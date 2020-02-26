package com.nagarro.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.entity.EndUser;
import com.nagarro.hibernateUtil.HibernateUtil;

public class HrUtil implements HrUtilDao {
	@Autowired
	HibernateUtil hb;

	public void create(String uname, String pass) {
		EndUser user = new EndUser();
		user.setUname(uname);
		user.setPassword(pass);
		Session session = hb.getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();

	}

}
