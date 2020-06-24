package com.kioshq.distro.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kioshq.distro.dto.OrganizationTemplate;
import com.kioshq.distro.entity.Organization;
import com.kioshq.distro.entity.Person;
import com.kioshq.distro.repository.OrganizationRepository;
import com.kioshq.distro.service.AuthenticationService;
import com.kioshq.distro.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	AuthenticationService authService;

	@Override
	public Organization createNewOrganization(OrganizationTemplate organization) {
		Person user = authService.findUser(organization.getOwnerId());

		List<Person> userList = new ArrayList<>();
		userList.add(user);

		Organization newOrg = new Organization(organization.getName(), userList);
		return organizationRepository.save(newOrg);
	}

	public Organization getOrganizationById(Long id) {
		Organization organization = organizationRepository.findById(id).get();

		return organization;
	}

	@Override
	public List<Organization> getOrganizationsByUserId(Long userId) {
		Person user = authService.findUser(userId);
		return user.getOrganizations();
	}

}
