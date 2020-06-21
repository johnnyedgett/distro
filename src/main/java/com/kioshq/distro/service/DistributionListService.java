package com.kioshq.distro.service;

import java.util.List;

import com.kioshq.distro.dto.DistributionListTemplate;
import com.kioshq.distro.entity.DistributionList;

public interface DistributionListService {
	DistributionList createNewDistributionList(DistributionListTemplate dlTemplate);

	DistributionList findDistributionList(Long listId);

	List<DistributionList> getAllDistributionLists();

}
