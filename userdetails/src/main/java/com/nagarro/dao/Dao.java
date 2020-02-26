package com.nagarro.dao;

import java.util.List;

import org.hibernate.Session;

import com.nagarro.Entity.Entity;
import com.nagarro.hibernateUtil.HibernateUtil;

public class Dao implements DaoEmp {

	@Override
	public void create(Entity entity) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();

		session.save(entity);

		session.getTransaction().commit();

//	}
//	List<Entity> a = null;
//	public Dao() {
//		String s = "21-1-1998";
//		SimpleDateFormat smd = new SimpleDateFormat("dd-mm-yyyy");
//		Date d = null;
//		try {
//			d = smd.parse(s);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		Entity obj = new Entity();
//		obj.setEcode(1);
//		obj.setEname("object1");
//		obj.setLocation("abc");
//		obj.setEid("ab");
//		obj.setDob(d);
//		Entity ob = new Entity();
//		ob.setEcode(2);
//		ob.setEname("object2");
//		ob.setLocation("abc");
//		ob.setEid("ab");
//		ob.setDob(d);
//		a = new ArrayList<>();
//		
//		a.add(obj);
//		a.add(ob);
//		
////	}
//		public List<Entity> get() {
//		return a;
//	}
//	public Entity getEntity(int id) {
//		// TODO Auto-generated method stub
//		for(Entity e : a) {
//			if(e.getEcode()==id) {
//				return e;
//			}
//		}
//		return null;
	}

	@Override
	public List<Entity> retrieve() {

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Entity> arr = session.createSQLQuery("select * from Entity").addEntity(Entity.class).list();

		session.getTransaction().commit();
		return arr;
	}

	@Override
	public void update(Entity entity) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		int i = session.createSQLQuery("\r\n"
				+ "update  Entity set dob = :dob , eid = :eid,ename = :ename ,location = :location where ecode = :ecode")
				.addEntity(Entity.class).setParameter("dob", entity.getDob()).setParameter("eid", entity.getEid())
				.setParameter("ename", entity.getEname()).setParameter("location", entity.getLocation())
				.setParameter("ecode", entity.getEcode()).executeUpdate();
		System.out.println(i);

		session.getTransaction().commit();

	}

	@Override
	public void delete(int id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		Entity emp = session.get(Entity.class, id);
		if (emp != null) {
			session.remove(emp);
		}

		session.getTransaction().commit();
	}

	public Entity getEntity(int id) {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Entity> arr = session.createSQLQuery("select * from Entity").addEntity(Entity.class).list();

		session.getTransaction().commit();
		for (Entity e : arr) {
			if (e.getEcode() == id) {
				return e;
			}
		}

		return null;
	}

}
