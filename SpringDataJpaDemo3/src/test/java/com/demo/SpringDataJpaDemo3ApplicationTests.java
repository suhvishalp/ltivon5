package com.demo;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entities.Address;
import com.demo.entities.Customer;
import com.demo.repositories.AddressRepository;
import com.demo.repositories.CustomerRepository;

@SpringBootTest
class SpringDataJpaDemo3ApplicationTests {
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Autowired
	private AddressRepository addRepo;

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
	
	@Test
	@Transactional
	public void testFetchCustomer() {
		Optional<Customer> optCustomer =  custRepo.findById(1L);
	
		if(optCustomer.isPresent()) {
			Customer cust = optCustomer.get();
			System.out.println(cust.getAddresses());
		}
	}
}














