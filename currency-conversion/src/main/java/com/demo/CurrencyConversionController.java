package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy currencyExProxy;

	@GetMapping("/currency-conversion/{from}/{to}/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable("from") String from, 
			@PathVariable("to") String to, 
			@PathVariable("quantity") int quantity) {
		
		
		//make http get request to currency-exchange service
//		HashMap<String, String> uriVariables = new HashMap<>();
//		uriVariables.put("from", "USD");
//		uriVariables.put("to", "INR");
//		
//		CurrencyExchange ce =	new RestTemplate()
//									.getForObject("http://localhost:8082/currency-exchange/{from}/{to}", 
//											CurrencyExchange.class, 
//											uriVariables);
		
		CurrencyExchange ce = currencyExProxy.retrieveCurrencyExchange(from, to);

		
		CurrencyConversion cc = new CurrencyConversion();
		
		cc.setId(101);
		cc.setFrom(from);
		cc.setTo(to);
		cc.setQuantity(quantity);
		double rate = ce.getExchangeRate();
		cc.setExchangeRate(rate);
		double amount = quantity * rate;
		cc.setTotalAmount(amount);
		
		return cc;
		
	}
}
