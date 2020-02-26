package com.nagarro.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.model.User;

public class LoginDao {

	public static boolean getCredintials(String uname, String pass) {
	
		boolean result = false;
		User obj = null;
		Session sc = HibernateUtil.getSession();
		Transaction t = sc.beginTransaction();
		obj = (User) sc.createQuery("from LoginModel where uname = '"+uname+"'");
		t.commit();
		if (obj != null && obj.getPassword().equals(pass)) {
			result = true;
		}
		return result;
	}

}
