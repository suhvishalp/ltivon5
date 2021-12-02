package com.demo;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;import org.springframework.beans.factory.parsing.EmptyReaderEventListener;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Employee;
import com.demo.entities.QEmployee;
import com.demo.repositories.EmployeeRepository;
import com.querydsl.jpa.impl.JPAQuery;

@SpringBootTest
class SpringDataJpaDemo2ApplicationTests {
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void testFetchAllEmp() {
//		Iterable<Employee> list =  empRepo.findAll();
//		
//		list.forEach(e -> System.out.println(e));
//	}
	
//	@Test
//	public void testGetAllEmpByCity() {
//		
//		
//		List<Employee> list =  empRepo.getAllEmpByCity("Hyd");
//		list.forEach(e -> System.out.println(e));
//	}
//	
	
//	@Test
//	public void testGetAllEmpBySalary() {
//		
//		
//		List<Employee> list =  empRepo.getAllEmpBySal(3000.00);
//		list.forEach(e -> System.out.println(e));
//	}
	
//	@Test
//	public void testFindAllByCity() {
//		
//		
//		List<Employee> list =  empRepo.findAllByCity("BLR");
//		list.forEach(e -> System.out.println(e));
//	}
	
//	@Test
//	public void testFindAllByCityAndSalary() {
//		
//		
//		List<Employee> list =  empRepo.findAllByCityAndSalaryGreaterThan("BLR", 3000.00);
//		list.forEach(e -> System.out.println(e));
//	}
	
//	
//	@Test
//	public void testfindAllByNameStartingWith() {
//		
//		
//		List<Employee> list =  empRepo.findAllByNameStartingWith("A");
//		list.forEach(e -> System.out.println(e));
//	}
	
	@Test
	public void testQueryDSL() {
		
		QEmployee employee = QEmployee.employee;
		
		JPAQuery<Employee> query = new JPAQuery<>(entityManager);
		
		List<Employee> list = query.from(employee)
								.fetch();
		
		list.forEach(e -> System.out.println(e));
		
		

	}

}











