package com.kioshq.distro.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.distro.dto.PersonTemplate;
import com.kioshq.distro.entity.Person;
import com.kioshq.distro.service.AuthenticationService;
import com.kioshq.distro.util.UserPrincipal;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);
	
	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	// TODO
	@PostMapping("/register")
	public ResponseEntity<Person> registerNewUser(@RequestBody PersonTemplate newPerson) {
		LOG.info(String.format("Registering new user: %s", newPerson.getUsername()));
		try {
			Person user = authenticationService.registerNewPerson(newPerson);
			LOG.info("Here");
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			LOG.error(e.getMessage());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Person> loginPerson(@RequestBody PersonTemplate person) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						person.getUsername(),
						person.getPassword())
				);
			
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Map<String, String> responseMap = new HashMap<>();
		if(authentication.getPrincipal()!=null) {
			Person loggedInUser = ((UserPrincipal) authentication.getPrincipal()).getUser();
			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
		} else {
			responseMap.put("Error", "Error with request");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/currentUser")
	public ResponseEntity<Person> getCurrentUser() {
		Map<String, String> responseMap = new HashMap<>();
		if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			responseMap.put("Error", "Error with request");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			Person loggedInUser = user.getUser();
			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
			
		}
	}

	/* Dev Routes - pls remove thx */
	@GetMapping("/dev/{id}")
	public ResponseEntity<Person> devGetUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(authenticationService.findUser(id), HttpStatus.OK);
	}
}
