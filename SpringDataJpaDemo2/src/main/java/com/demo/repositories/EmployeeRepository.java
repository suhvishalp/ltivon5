package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entities.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
		//custom query using @Query & JPQL Statement 
//		@Query(value ="SELECT e from Employee e where e.city=:city") 
//		public List<Employee> getAllEmpByCity(@Param("city") String city);
//		
		//custom query using native sql statement 
	    @Query(value ="SELECT * from Employee where city=:city", nativeQuery = true) 
		public List<Employee> getAllEmpByCity(@Param("city") String city);
		
	    //named query
	    List<Employee> getAllEmpBySal(@Param("salary") double salary);
	    
	    List<Employee>  findAllByCity(String city);
	    
	    List<Employee>	findAllByCityAndSalaryGreaterThan(String city, double salary);
	    
	    List<Employee> findAllByNameStartingWith(String str);

}


//spring data jpa will provide a proxy instance of this emprepository