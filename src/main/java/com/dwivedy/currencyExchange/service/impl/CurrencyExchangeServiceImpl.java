package com.dwivedy.currencyExchange.service.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.dwivedy.currencyExchange.json.ExchangeRateJson;
import com.dwivedy.currencyExchange.service.CurrencyExchangeService;
 
@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {


	
	@Override
	public ExchangeRateJson getExchangeRateSixMonth()  {
		
		Map<String, List<Map<String,Double>>> rates= new HashMap<>();
		
		List<Map<String,Double>> gBPs = new LinkedList<>();
		List<Map<String,Double>> uSDs = new LinkedList<>();
		List<Map<String,Double>> hKDs = new LinkedList<>();
 
		
		 
		String keyGBP="GBP";
		String keyUSD="USD";
		String keyHKD="HKD";
		ExchangeRateJson exchangeRateJson=new ExchangeRateJson();
		for(int i=0;i<6;i++){
			
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -i);
			Date result = cal.getTime();
			
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(result);
			System.out.println(date);
		
				 exchangeRateJson = WebClient.create().get()
		        .uri("https://api.ratesapi.io/api/"+date)
		        .accept(MediaType.APPLICATION_JSON)
		        .retrieve()
		        .bodyToMono(ExchangeRateJson.class).block();
				System.out.println(exchangeRateJson);
		
				Map<String,Double> monthRateMappingGBP= new HashMap<>();
				monthRateMappingGBP.put("Month"+i, exchangeRateJson.getRates().get(keyGBP));
				Map<String,Double> monthRateMappingUSD= new HashMap<>();
				monthRateMappingUSD.put("Month"+i, exchangeRateJson.getRates().get(keyUSD));
				Map<String,Double> monthRateMappingHKD= new HashMap<>();
				monthRateMappingHKD.put("Month"+i, exchangeRateJson.getRates().get(keyHKD));
				
				gBPs.add(monthRateMappingGBP);
				uSDs.add(monthRateMappingUSD);
				hKDs.add(monthRateMappingHKD);
				
 

		
		}
		
		rates.put(keyGBP, gBPs);
		rates.put(keyUSD, uSDs);
		rates.put(keyHKD, hKDs);
		exchangeRateJson.setRates(null);
		exchangeRateJson.setRatesMap(rates);
		return exchangeRateJson;
		
		
	}

	@Override
	public ExchangeRateJson getExchangeRateLatest(String latest) {
		Map<String,Double> monthRateMapping= new HashMap<>();
		String keyGBP="GBP";
		String keyUSD="USD";
		String keyHKD="HKD";
		ExchangeRateJson exchangeRateJson = WebClient.create().get()
			        .uri("https://api.ratesapi.io/api/"+latest)
			        .accept(MediaType.APPLICATION_JSON)
			        .retrieve()
			        .bodyToMono(ExchangeRateJson.class).block();
		
		monthRateMapping.put(keyGBP, exchangeRateJson.getRates().get(keyGBP));
		monthRateMapping.put(keyUSD, exchangeRateJson.getRates().get(keyUSD));
		monthRateMapping.put(keyHKD, exchangeRateJson.getRates().get(keyHKD));
		exchangeRateJson.setRates(monthRateMapping);
		return exchangeRateJson;
	}
	
	
}
