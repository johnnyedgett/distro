package com.kioshq.poojadl.service;

import java.util.List;

import com.kioshq.poojadl.dto.OrganizationTemplate;
import com.kioshq.poojadl.entity.Organization;

public interface OrganizationService {
	Organization createNewOrganization(OrganizationTemplate organization);

	Organization getOrganizationById(Long id);

	List<Organization> getOrganizationsByUserId(Long userId);
}
