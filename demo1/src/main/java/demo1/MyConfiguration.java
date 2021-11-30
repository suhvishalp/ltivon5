package demo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

	
	@Bean
	public Employee createEmp() {
		Employee emp = new Employee();
		emp.setName("vishaal");
		return emp;
	}
}
