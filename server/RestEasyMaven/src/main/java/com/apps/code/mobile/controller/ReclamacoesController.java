package com.apps.code.mobile.controller;

import javax.persistence.EntityManager;

import com.apps.code.mobile.model.Reclamacoes;

public class ReclamacoesController {
	public Reclamacoes postReclamacoes (EntityManager entityManager, Reclamacoes reclamacoes) {
		entityManager.getTransaction().begin();
		Reclamacoes nova = entityManager.merge(reclamacoes);
		entityManager.getTransaction().commit();
		return nova;
	}
}
