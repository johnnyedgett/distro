package com.kioshq.distro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.distro.dto.OrganizationTemplate;
import com.kioshq.distro.entity.Organization;
import com.kioshq.distro.service.OrganizationService;

@RestController
@RequestMapping("/api/organization")
public class OrganizationController {

	@Autowired
	OrganizationService organizationService;
	
	@PostMapping("/create")
	public ResponseEntity<Organization> createOrganization(@RequestBody OrganizationTemplate template) {
		Organization newOrganization = organizationService.createNewOrganization(template);
		return new ResponseEntity<>(newOrganization, HttpStatus.OK);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Organization> getOrganization(@PathVariable("id") Long id){
		Organization organization = organizationService.getOrganizationById(id);
		return new ResponseEntity<>(organization, HttpStatus.OK);
	}
	
	@GetMapping("/get/user/{id}")
	public ResponseEntity<List<Organization>> getOrganizationsForUser(@PathVariable("id") Long id){
		List<Organization> organizations = organizationService.getOrganizationsByUserId(id);
		return new ResponseEntity<>(organizations, HttpStatus.OK);
	}
	
}
