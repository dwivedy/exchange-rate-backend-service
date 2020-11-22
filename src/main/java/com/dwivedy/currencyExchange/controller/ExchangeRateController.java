package com.dwivedy.currencyExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dwivedy.currencyExchange.authmodel.AuthenticationRequest;
import com.dwivedy.currencyExchange.authmodel.AuthenticationResponse;
import com.dwivedy.currencyExchange.json.ExchangeRateJson;
import com.dwivedy.currencyExchange.jwt.util.Jwtutil;
import com.dwivedy.currencyExchange.service.impl.CurrencyExchangeServiceImpl;
import com.dwivedy.currencyExchange.service.impl.MyUserDetailsService;
 

/**
 * @author Pawan
 *
 *         This class is the entry point for excahnge rate microservice  and acts as
 *         the controller.
 */

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ExchangeRateController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private Jwtutil jwtTokenUtil;

	@Autowired
	private MyUserDetailsService userDetailsService;


	@Autowired
	private CurrencyExchangeServiceImpl currencyExchangeServiceImpl;

	 

	@GetMapping(value = "/data")
	public ResponseEntity<ExchangeRateJson> getExchangeRateSixMonthAndLatest(@RequestParam("data") String data) throws Exception {
		
		HttpStatus statusCode = HttpStatus.NOT_FOUND;
		
		ExchangeRateJson exchangeRateJson= null;
		
		if(data.equals("sixMonth")) {
			 exchangeRateJson= currencyExchangeServiceImpl.getExchangeRateSixMonth();
		}else {
			 exchangeRateJson= currencyExchangeServiceImpl.getExchangeRateLatest(data);
		}
		
		statusCode= HttpStatus.OK;
		
		 return new ResponseEntity<>(exchangeRateJson, statusCode);

	}
	
	 
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());
		
		System.out.println(userDetails);

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	
	
	


}
