package com.dwivedy.currencyExchange.json;

import java.util.List;
import java.util.Map;

 
public class ExchangeRateUpdatedJson {
	
 
	
	private String base;
	
	 
    private Map<String, List<Map<String,Double>>>  rates;
    
    private  Map<String,Double>  rateMap;

    public Map<String, Double> getRateMap() {
		return rateMap;
	}




	public void setRateMap(Map<String, Double> rateMap) {
		this.rateMap = rateMap;
	}




	private String date;

	public String getBase() {
		return base;
	}

	
 

	 



	public Map<String, List<Map<String, Double>>> getRates() {
		return rates;
	}




	public void setRates(Map<String, List<Map<String, Double>>> rates) {
		this.rates = rates;
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
		return "ExchangeRateJson [base=" + base + ", rates=" + rates + ", rateMap=" + rateMap + ", date=" + date + "]";
	}




	 

	 
	
    
    

}
