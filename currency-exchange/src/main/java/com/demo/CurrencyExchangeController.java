package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	
	@Autowired
	private Environment environment;
	
	@GetMapping("/currency-exchange/{from}/{to}")
	public CurrencyExchange retrieveExchangeRate(@PathVariable("from") String from, @PathVariable("to") String to) {
		
		CurrencyExchange ex =  new CurrencyExchange();
		ex.setId(1001);
		ex.setFrom(from);
		ex.setTo(to);
		ex.setExchangeRate(76.00);
		
		String port = environment.getProperty("local.server.port");
		ex.setPort(port);
		
		return ex;
	}
}
