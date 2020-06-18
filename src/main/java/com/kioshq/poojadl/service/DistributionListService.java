package com.kioshq.poojadl.service;

import java.util.List;

import com.kioshq.poojadl.dto.DistributionListTemplate;
import com.kioshq.poojadl.entity.DistributionList;

public interface DistributionListService {
	DistributionList createNewDistributionList(DistributionListTemplate dlTemplate);

	DistributionList findDistributionList(Long listId);

	List<DistributionList> getAllDistributionLists();

}
