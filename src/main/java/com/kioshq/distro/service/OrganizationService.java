package com.kioshq.distro.service;

import java.util.List;

import com.kioshq.distro.dto.OrganizationTemplate;
import com.kioshq.distro.entity.Organization;

public interface OrganizationService {
	Organization createNewOrganization(OrganizationTemplate organization);

	Organization getOrganizationById(Long id);

	List<Organization> getOrganizationsByUserId(Long userId);
}
