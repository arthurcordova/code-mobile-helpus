package com.apps.code.mobile.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.apps.code.mobile.model.Claim;

public class ClaimController {
	public Claim putClaim (EntityManager entityManager, Claim claim) {
		entityManager.getTransaction().begin();
		Claim newClaim = entityManager.merge(claim);
		entityManager.getTransaction().commit();
		entityManager.close();
		return newClaim;
	}
	
	public Claim postClaim (EntityManager entityManager, Claim claim) {
		entityManager.getTransaction().begin();
		Claim newClaim = entityManager.merge(claim);
		entityManager.getTransaction().commit();
		entityManager.close();
		return newClaim;
	}
	
	public Claim getClaim(EntityManager entityManager, int id) {
		entityManager.getTransaction().begin();
		Claim claim = entityManager.find(Claim.class, id);
		entityManager.close();
		return claim;
	}
	
	public List<Claim> getAllClaim(EntityManager entityManager) {
		return entityManager.createNamedQuery("getClaim",Claim.class).getResultList();
	}
}
