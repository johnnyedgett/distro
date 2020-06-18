package com.kioshq.poojadl.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kioshq.poojadl.dto.OrganizationTemplate;
import com.kioshq.poojadl.entity.Organization;
import com.kioshq.poojadl.entity.User;
import com.kioshq.poojadl.repository.OrganizationRepository;
import com.kioshq.poojadl.service.AuthenticationService;
import com.kioshq.poojadl.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	OrganizationRepository organizationRepository;

	@Autowired
	AuthenticationService authService;

	@Override
	public Organization createNewOrganization(OrganizationTemplate organization) {
		User user = authService.findUser(organization.getOwnerId());

		List<User> userList = new ArrayList<>();
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
		User user = authService.findUser(userId);
		return user.getOrganizations();
	}

}
