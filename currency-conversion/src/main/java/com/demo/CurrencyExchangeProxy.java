package com.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="currency-exchange", url="http://localhost:8082")
@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {

	@GetMapping("/currency-exchange/{from}/{to}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable("from") String from, @PathVariable("to") String to);
	
}
