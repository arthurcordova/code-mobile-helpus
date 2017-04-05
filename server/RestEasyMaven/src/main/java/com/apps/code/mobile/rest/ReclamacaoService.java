package com.apps.code.mobile.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.apps.code.mobile.controller.ReclamacoesController;
import com.apps.code.mobile.model.Reclamacoes;

@Path("/reclamacoes")
public class ReclamacaoService {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("codeMobile");
	
	@GET	
    @Produces({MediaType.APPLICATION_JSON})
	public List<Reclamacoes> getReclamacoes() {		
		System.out.println("entityManager "+ entityManagerFactory);
		EntityManager entityManager = entityManagerFactory.createEntityManager();		
		return entityManager.createNamedQuery("getReclamacoes",Reclamacoes.class).getResultList();
	}
	
	@POST
	@Path("/post")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Reclamacoes postReclamacoes(Reclamacoes reclamacoes) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {			
			ReclamacoesController reclamacoesController = new ReclamacoesController();
			return reclamacoesController.postReclamacoes(entityManager, reclamacoes);
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		return null;
	}
}
