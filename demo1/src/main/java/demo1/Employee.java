package demo1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee  {  //implements InitializingBean, DisposableBean
	
	private int id;
	private String name;
	private String city;
	private double salary;
	
	public Employee() {
		super();
		System.out.println("Employee constructor called");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("setter method is called");
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
		@PostConstruct
		public void myOwnInitMethod() {
			System.out.println("this is the place for initilization/validation/etc");
		}
		
		@PreDestroy
		public void myOwnDestroyMethod() {
			System.out.println("releasing resources using destroy method ");
		}
	
	

//	public void afterPropertiesSet() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("this is the place for initilization/validation/etc");
//	}
//
//	public void destroy() throws Exception {
//		// TODO Auto-generated method stub
//		System.out.println("releasing resources using destroy method ");
//	} 
	
//	
//	public void init() {
//		System.out.println("this is the place for initilization/validation/etc");
//	}
//	
//	public void destroy() {
//		System.out.println("releasing resources using destroy method ");
//	}
	

}
