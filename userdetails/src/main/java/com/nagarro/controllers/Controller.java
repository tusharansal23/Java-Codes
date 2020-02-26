package com.nagarro.controllers;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.nagarro.Entity.Entity;
import com.nagarro.dao.Dao;

@Path("obj")
public class Controller {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Entity> get() {
		System.out.println("Hii");
		Dao obj = new Dao();
		return obj.retrieve();
	}

	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Entity get(@PathParam("id") int id) {
		System.out.println("Hii");
		Dao obj = new Dao();
		return obj.getEntity(id);
	}

	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam("id") int id) {
		System.out.println("Hii");
		Dao obj = new Dao();
		obj.delete(id);
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)

	public void getDetails(Entity entity) {
		Dao obj = new Dao();
		obj.create(entity);
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)

	public void update(Entity entity) {
		System.out.println("Hii");
		Dao obj = new Dao();
		obj.update(entity);
	}

//	@DELETE
//	@Path("obj/delete")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public void delete(Entity entity) {
//		System.out.println("Hii");
//		Dao obj  = new Dao();
//		   obj.delete(entity);
//		}

}
