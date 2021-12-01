package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaDemo1");
		
		EntityManager entityManager = factory.createEntityManager();
		
		Employee emp = new Employee(1, "Aakash",  "Hyderabad", 2000.00);
		EntityTransaction tx = entityManager.getTransaction();
		
		tx.begin();
		entityManager.persist(emp);
		tx.commit();

	}

}
