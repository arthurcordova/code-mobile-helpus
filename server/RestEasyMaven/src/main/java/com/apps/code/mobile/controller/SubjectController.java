package com.apps.code.mobile.controller;

import java.util.List;

import javax.persistence.EntityManager;

import com.apps.code.mobile.model.Subject;

public class SubjectController {
	public Subject putSubject(EntityManager entityManager, Subject subject) {
		entityManager.getTransaction().begin();
		Subject newSubject = entityManager.merge(subject);
		entityManager.getTransaction().commit();
		entityManager.close();
		return newSubject;
	}
	
	public Subject postSubject(EntityManager entityManager, Subject subject) {
		entityManager.getTransaction().begin();
		Subject newSubject = entityManager.merge(subject);
		entityManager.getTransaction().commit();
		entityManager.close();
		return newSubject;
	}
	
	public List<Subject> getSubject(EntityManager entityManager) {		
		return entityManager.createNamedQuery("getSubject",Subject.class).getResultList();		
	}
	
	public Subject getSubject(EntityManager entityManager, int id) {
		entityManager.getTransaction().begin();
		Subject subject = entityManager.find(Subject.class, id);
		entityManager.close();
		return subject;
	}
}
