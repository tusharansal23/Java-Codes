package com.nagarro.authenticator;

import org.hibernate.Session;

import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.entity.EndUser;
import com.nagarro.hibernateUtil.HibernateUtil;

public class Authenticator {
	@Autowired
	HibernateUtil hb;
	
	public boolean check(String uname , String pass) {
		boolean result = false;
		EndUser obj = null;
		Session sc = hb.getSession();
		Transaction t = sc.beginTransaction();
		obj = sc.get(EndUser.class, uname);
		t.commit();
		if (obj != null && obj.getPassword().equals(pass)) {
			result = true;
		}
		return result;
	}

}
