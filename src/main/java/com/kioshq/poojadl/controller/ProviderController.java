package com.kioshq.poojadl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.poojadl.entity.Provider;
import com.kioshq.poojadl.service.ProviderService;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {

	@Autowired
	ProviderService providerService;
	
	@PostMapping("/register")
	public ResponseEntity<Provider> registerNewProvider(@RequestBody Provider provider) {
		try { 
			Provider newProvider = providerService.registerProvider(provider);
			return new ResponseEntity<>(newProvider, HttpStatus.CREATED);
		} catch(Exception e) { 
			// TODO do something more useful with the exception/error handling
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
