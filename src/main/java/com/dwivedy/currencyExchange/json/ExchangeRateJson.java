package com.dwivedy.currencyExchange.json;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExchangeRateJson {
	
 
	
	private String base;

    private  Map<String,Double>  rates;

    private Map<String, List<Map<String,Double>>>  ratesMap;
    




	public Map<String, List<Map<String, Double>>> getRatesMap() {
		return ratesMap;
	}


	public void setRatesMap(Map<String, List<Map<String, Double>>> ratesMap) {
		this.ratesMap = ratesMap;
	}


	public Map<String, Double> getRates() {
		return rates;
	}


	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}




	private String date;

	public String getBase() {
		return base;
	}


	public void setBase(String base) {
		this.base = base;
	}
 

	public String getDate() {
		return date;
	}
 

	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "ExchangeRateJson [base=" + base + ", rates=" + rates + ", ratesMap=" + ratesMap + ", date=" + date
				+ "]";
	}



 

    
    

}
