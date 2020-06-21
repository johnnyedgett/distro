package com.kioshq.distro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.distro.dto.UserTemplate;
import com.kioshq.distro.entity.User;
import com.kioshq.distro.service.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	AuthenticationService authenticationService;

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
	public ResponseEntity<User> loginUser(@RequestBody UserTemplate user) {
		try {
			User loggedInUser = authenticationService.loginUser(user);
			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	// @GetMapping("/session")

	/* Dev Routes - pls remove thx */
	@GetMapping("/dev/{id}")
	public ResponseEntity<User> devGetUser(@PathVariable("id") Long id) {
		return new ResponseEntity<>(authenticationService.findUser(id), HttpStatus.OK);
	}
}
