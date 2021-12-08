package com.demo.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.entities.Employee;
import com.demo.exceptions.EmployeeNotFoundException;
import com.demo.exceptions.ErrorMessage;
import com.demo.exceptions.FieldErrorMessage;
import com.demo.services.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/api/employees")
	public List<Employee> getAllEmp(){
		return empService.getAllEmp();
	}
	
	@GetMapping("/api/employees/{empid}")
	public Employee getEmp(@PathVariable("empid") Long id) {
		Employee emp =  empService.getEmp(id);
		
		if(emp == null) {
			throw new EmployeeNotFoundException("Employee with given id " + id  + " is not found");
		}
		
		return emp;
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMessage> myErrorHandler(EmployeeNotFoundException ex) {
		return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage(), "404"), HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/api/employees")
	public ResponseEntity<Employee> saveEmp(@Valid @RequestBody() Employee emp) {
		
		Employee e = empService.save(emp);
		
		///api/employees/{id}				//e.getId()
		
		URI location =  ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(e.getId())
				.toUri();
		
		//return ResponseEntity.created(location).build();
		
		//ResponseEntity
		return new ResponseEntity<Employee>(e, HttpStatus.CREATED);
		 
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<FieldErrorMessage>> requestBodyValidationExceptionHandler(MethodArgumentNotValidException ex){
		
		
		List<FieldError> list =  ex.getFieldErrors();
		
		List<FieldErrorMessage> errorList = new ArrayList<>();
		
		for(FieldError error : list) {
			errorList.add(new FieldErrorMessage(error.getField(), error.getDefaultMessage()));
		}
		
		return new ResponseEntity<List<FieldErrorMessage>>(errorList, HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	
	
	
	@PutMapping("/api/employees/{empid}")
	public Employee updateEmp(@RequestBody() Employee emp, @PathVariable("empid")  Long id) {
		Employee e =  empService.updateEmp(emp, id);
		
		if(e == null) {
			throw new RuntimeException("emp with given id not found");
		}
		
		return e;
	}
	
	@DeleteMapping("/api/employees/{empid}")
	public Employee deleteEmp(@PathVariable("empid") Long id) {
		return empService.removeEmp(id);
	}
}
