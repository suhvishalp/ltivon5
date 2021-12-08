package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Employee;
import com.demo.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee save(Employee emp) {
		return empRepo.save(emp);
	}
	
	public Employee getEmp(Long id) {
		Optional<Employee> optEmp =  empRepo.findById(id);
		if(optEmp.isPresent()) {
			Employee e = optEmp.get();
			return e;
		}
		return null;
	}
	
	public List<Employee> getAllEmp(){
		return empRepo.findAll();
	}
	
	public Employee removeEmp(Long id) {
		Optional<Employee> optEmp =  empRepo.findById(id);
		if(optEmp.isPresent()) {
			Employee e = optEmp.get();
			empRepo.delete(e);
			return e;
		}
		return null;
	}
	
	public Employee updateEmp(Employee emp, Long id) {
	
		Optional<Employee> optEmp =  empRepo.findById(id);
		if(optEmp.isPresent()) {
			Employee e = optEmp.get();
				
			e.setCity(emp.getCity());
			e.setName(emp.getName());
			e.setSalary(emp.getSalary());
			empRepo.save(e);

			return e;
		}
		return null;
	}
	
}
