package com.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("JpaDemo1");
		
		EntityManager entityManager = factory.createEntityManager();
		
//		Employee emp = new Employee(1, "Aakash",  "Hyderabad", 2000.00);
		EntityTransaction tx = entityManager.getTransaction();
		
		
//		Query query = entityManager.createQuery("SELECT e From Employee e where e.city=?1");
//		query.setParameter(1, "BLR");
//		List list = query.getResultList();
		
	
		
		
		TypedQuery<Employee> query1 = entityManager.createQuery("SELECT e From Employee e where e.city=?1", Employee.class);
		query1.setParameter(1, "BLR");
		List<Employee> list1 = query1.getResultList();
		
		for(Employee emp : list1) {
			System.out.println(emp);
		}
		
		
//		tx.begin();
//		entityManager.persist(emp);
//		tx.commit();
		
//		Employee e = entityManager.find(Employee.class, 1);
//		System.out.println(e);
//		
////		tx.begin();
////		e.setCity("Mumbai");
////		tx.commit();
//		
//		tx.begin();
//		entityManager.remove(e);
//		tx.commit();
		

	}

}
