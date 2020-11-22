package com.dwivedy.currencyExchange.service;

import com.dwivedy.currencyExchange.json.ExchangeRateJson;

public interface CurrencyExchangeService {
	
	
	  ExchangeRateJson getExchangeRateSixMonth();
	 ExchangeRateJson getExchangeRateLatest(String latest);

}
