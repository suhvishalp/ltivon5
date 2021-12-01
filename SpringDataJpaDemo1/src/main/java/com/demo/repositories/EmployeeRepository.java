package com.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	
//	long	count()
//  <S extends T> S	save(S entity)
//  Iterable<T>	findAll()
//  Optional<T>	findById(ID id)
//  void	delete(T entity)
	
}


//spring data jpa intelligently generates an implementation class of this  repository interface 