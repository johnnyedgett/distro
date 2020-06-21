package com.kioshq.distro.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kioshq.distro.dto.DistributionListTemplate;
import com.kioshq.distro.entity.DistributionList;
import com.kioshq.distro.entity.Organization;
import com.kioshq.distro.repository.DistributionListRepository;
import com.kioshq.distro.service.DistributionListService;
import com.kioshq.distro.service.OrganizationService;

@Service
public class DistributionListServiceImpl implements DistributionListService {

	@Autowired
	DistributionListRepository dlRepository;

	@Autowired
	OrganizationService organizationService;

	@Override
	public DistributionList findDistributionList(Long listId) {
		return dlRepository.findById(listId).get();
	}

	@Override
	public DistributionList createNewDistributionList(DistributionListTemplate dlTemplate) {
		Organization organization = organizationService.getOrganizationById(dlTemplate.getOrganizationId());
		DistributionList distributionList = new DistributionList(dlTemplate.getListName(), organization);

		return dlRepository.save(distributionList);
	}

	@Override
	public List<DistributionList> getAllDistributionLists() {
		List<DistributionList> dlList = new ArrayList<>();
		Iterable<DistributionList> dlIterable = dlRepository.findAll();
		dlIterable.forEach(dlList::add);
		return dlList;
	}

}
