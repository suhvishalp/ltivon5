package com.demo;

public class CurrencyExchange {

	private int id;
	private String from;
	private String to;
	private double exchangeRate;
	private String port;
	
	public CurrencyExchange() {
		super();
	}
	
	

	public String getPort() {
		return port;
	}



	public void setPort(String port) {
		this.port = port;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}
	
	
	
}
