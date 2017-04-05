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

import com.apps.code.mobile.controller.ClaimController;
import com.apps.code.mobile.model.Claim;

@Path("/claim")
public class ClaimService {
	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("codeMobile");
	private ClaimController claimController = new ClaimController();
	
	@GET	
    @Produces({MediaType.APPLICATION_JSON})
	public List<Claim> getAllClaim() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return claimController.getAllClaim(entityManager);
	}
	
	@Path("{id}")
	@GET	
    @Produces({MediaType.APPLICATION_JSON})
	public Claim getClaim(@PathParam("id") int id) {
		System.out.println("ENTROU AQUI");
		EntityManager entityManager = entityManagerFactory.createEntityManager();		
		return claimController.getClaim(entityManager, id);
	}
	
	@POST
	@Path("/post")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Claim postClaim(Claim claim) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return claimController.postClaim(entityManager, claim);
	}
	
	@PUT
	@Path("/put")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Claim putClaim(Claim claim) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return claimController.putClaim(entityManager, claim);
	}
	

}
