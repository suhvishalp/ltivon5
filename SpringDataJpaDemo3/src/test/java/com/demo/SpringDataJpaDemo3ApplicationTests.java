package com.demo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Address;
import com.demo.entities.Customer;
import com.demo.entities.Employee;
import com.demo.repositories.AddressRepository;
import com.demo.repositories.CustomerRepository;
import com.demo.repositories.EmployeeRepository;

@SpringBootTest
class SpringDataJpaDemo3ApplicationTests {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private AddressRepository addRepo;
	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	
//	@Test
//	public void testCreateCustomer() {
//		
//		Customer cust1 = new Customer();
//		cust1.setName("vishaal");
//		cust1.setAge(38);
//		
//		Address a1 = new Address();
//		a1.setStreet("SC Road");
//		a1.setCity("Mumbai");
//		a1.setCustomer(cust1);
//		
//		Address a2 = new Address();
//		a2.setStreet("Ram Galli");
//		a2.setCity("Mumbai");
//		a2.setCustomer(cust1);
//		
//		Set<Address> set = new HashSet<>();
//		set.add(a1);
//		set.add(a2);
//		
//		cust1.setAddresses(set);
//		
//	
//		
//		custRepo.save(cust1);
//		
//	}
	
//	@Test
//	@Transactional
//	public void testFetchCustomer() {
//		Optional<Customer> optCustomer =  custRepo.findById(1L);
//	
//		if(optCustomer.isPresent()) {
//			Customer cust = optCustomer.get();	
//			System.out.println(cust.getAddresses());
//		}
//	}
	
	
	@Test
	public void testFind() {
		
		
		 empRepo.findById(1L);
		 empRepo.findById(1L);
		 empRepo.findById(1L);
		 empRepo.findById(1L);
		 empRepo.findById(1L);

		
		 	
	}
	
}














