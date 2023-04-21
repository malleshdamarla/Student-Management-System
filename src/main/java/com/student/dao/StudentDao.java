package com.student.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.student.dto.Admin;
import com.student.dto.Student;

public class StudentDao {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DMR");
	EntityManager entityManager= entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	public Student save(Student student) {
		if(student!=null) {
    		entityTransaction.begin();
    		entityManager.persist(student);
    		entityTransaction.commit();
    	}
    	return null;
		
	}
	
	public void update(Student student) {
			entityTransaction.begin();
    		entityManager.merge(student);
    		entityTransaction.commit();
	}
	
	public List<Student> getAllStudents(Admin admin){
		Query query=entityManager.createQuery("select a from Student a where a.admin=?1");
		query.setParameter(1,admin);//to represented like there are no of admin lke different restarents
		List student = query.getResultList();
		return student;
		
	}
	
	public Student getStudent(int StudentId) {
		return entityManager.find(Student.class, StudentId);
		
	}
	public void deleteStudent(int id) {
		entityTransaction.begin();
		entityManager.remove(entityManager.find(Student.class, id));
		entityTransaction.commit();
	}
}
