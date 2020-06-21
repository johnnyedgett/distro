package com.kioshq.distro.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.kioshq.distro.dto.UserTemplate;
import com.kioshq.distro.entity.User;
import com.kioshq.distro.service.AuthenticationService;
import com.kioshq.distro.util.UserPrincipal;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	// TODO
	@PostMapping("/register")
	public ResponseEntity<User> registerNewUser(@RequestBody UserTemplate newUser) {
		try {
			User user = authenticationService.registerNewUser(newUser);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> loginUser(@RequestBody UserTemplate user) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						user.getUsername(),
						user.getPassword())
				);
			
		SecurityContextHolder.getContext().setAuthentication(authentication);
		Map<String, String> responseMap = new HashMap<>();
		if(authentication.getPrincipal()!=null) {
			String username  = ((UserPrincipal) authentication.getPrincipal()).getUsername();
			responseMap.put("username", username);
			return new ResponseEntity<>(responseMap, HttpStatus.OK);
		} else {
			responseMap.put("Error", "Error with request");
			return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/currentUser")
	public ResponseEntity<Map<String, String>> getCurrentUser() {
		Map<String, String> responseMap = new HashMap<>();
		if(SecurityContextHolder.getContext().getAuthentication() instanceof AnonymousAuthenticationToken) {
			responseMap.put("Error", "Error with request");
			return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
		} else {
			UserPrincipal user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String username  = user.getUsername();
			responseMap.put("username", username);
			return new ResponseEntity<>(responseMap, HttpStatus.OK);
			
		}
	}

	/* Dev Routes - pls remove thx */
	@GetMapping("/dev/{id}")
	public ResponseEntity<User> devGetUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(authenticationService.findUser(id), HttpStatus.OK);
	}
}
