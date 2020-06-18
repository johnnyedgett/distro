package com.kioshq.poojadl.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kioshq.poojadl.dto.DistributionListTemplate;
import com.kioshq.poojadl.entity.DistributionList;
import com.kioshq.poojadl.repository.DistributionListRepository;
import com.kioshq.poojadl.service.DistributionListService;

@Service
public class DistributionListServiceImpl implements DistributionListService {

	@Autowired
	DistributionListRepository dlRepository;

	@Override
	public DistributionList findDistributionList(Long listId) {
		return dlRepository.findById(listId).get();
	}

	@Override
	public DistributionList createNewDistributionList(DistributionListTemplate dlTemplate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DistributionList> getAllDistributionLists() {
		// TODO Auto-generated method stub
		return null;
	}

}
