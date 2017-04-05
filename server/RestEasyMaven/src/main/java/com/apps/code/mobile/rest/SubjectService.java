package com.apps.code.mobile.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apps.code.mobile.controller.SubjectController;
import com.apps.code.mobile.model.Subject;

@Path("/subject")
public class SubjectService {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("codeMobile");
	private SubjectController controller = new SubjectController();	
	
	@GET	
    @Produces({MediaType.APPLICATION_JSON})
	public List<Subject> getAllSubject() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();		
		return controller.getSubject(entityManager);		
	}
	
	@Path("{id}")
	@GET	
    @Produces({MediaType.APPLICATION_JSON})
	public Subject getSubject(@PathParam("id") int id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return controller.getSubject(entityManager, id);
	}

	@POST
	@Path("/post")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Subject postSubject(Subject subject) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return controller.postSubject(entityManager, subject);		
	}
	
	@PUT
	@Path("/put")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Subject putSubject(Subject subject) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return controller.putSubject(entityManager, subject);
	}
}
