package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Employee.getAllEmpBySal", query = "SELECT e FROM Employee e WHERE e.salary > :salary")
public class Employee extends User {
	


	private Double salary;
	
	public Employee() {
		super();
	}

	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

}
