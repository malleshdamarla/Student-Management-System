package com.student.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.student.dto.Admin;

public class AdminDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DMR");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	public void AdminSignUp(Admin admin) {
		entityTransaction.begin();
		entityManager.persist(admin);
		entityTransaction.commit();
	}
	public Admin AdminLogin(String email, String password) {
//		Query query=entityManager.createQuery("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2");
//		query.setParameter(1, email);
//		query.setParameter(2, password);
//		
//		Admin admin=(Admin) query.getSingleResult();
//		return admin;
		try {
			Query query=entityManager.createQuery("select a from Admin a where a.adminEmail=?1 and a.adminPassword=?2");
			query.setParameter(1, email);
			query.setParameter(2, password);
			
			Admin admin=(Admin) query.getSingleResult();
			return admin;
		} catch (Exception e) {
			return null;
		}
	}
	public void UpdateAdmin(Admin admin) {
		entityTransaction.begin();
		entityManager.merge(admin);
		entityTransaction.commit();
		
	}
}
