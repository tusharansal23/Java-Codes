package com.nagarro.dao;

import java.util.List;

import com.nagarro.Entity.Entity;

public interface DaoEmp {
	void create(Entity entity);
	List<Entity> retrieve();
	void update(Entity entity);
	void delete(int id);

}
