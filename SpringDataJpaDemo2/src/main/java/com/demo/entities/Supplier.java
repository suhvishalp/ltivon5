package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Supplier extends User {

	private String supplierType;
	private String location;
	
	public Supplier() {
		super();
	}
	
}
