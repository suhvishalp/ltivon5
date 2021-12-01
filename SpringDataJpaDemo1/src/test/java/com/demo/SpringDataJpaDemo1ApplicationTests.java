package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Employee;
import com.demo.repositories.EmployeeRepository;

@SpringBootTest
class SpringDataJpaDemo1ApplicationTests {
	
	@Autowired
	private EmployeeRepository empRepo;
 
	@Test
	void contextLoads() {
	}

	
	@Test
	public void testCreateEmp() {
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("Vaibhav");
		emp.setCity("Hyd");
		emp.setSalary(1000.00);
		
		empRepo.save(emp);
	}
}
