package com.kioshq.distro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.distro.dto.DistributionListTemplate;
import com.kioshq.distro.entity.DistributionList;
import com.kioshq.distro.service.DistributionListService;

@RestController
@RequestMapping("/api/distributionlist")
public class DistributionListController {
	@Autowired
	DistributionListService dlService;

	@GetMapping("/all")
	public ResponseEntity<List<DistributionList>> getAllDistributionLists() {
		List<DistributionList> responseList = dlService.getAllDistributionLists();
		return new ResponseEntity<>(responseList, HttpStatus.OK);
	}

	@PostMapping("/create")
	public ResponseEntity<DistributionList> createPoojaDL(@RequestBody DistributionListTemplate dlTemplate) {
		DistributionList newDistributionList = dlService.createNewDistributionList(dlTemplate);
		return new ResponseEntity<>(newDistributionList, HttpStatus.OK);
	}

	// Get all subscriptions for a distribution list
//	@GetMapping("/get/{id}")
//	public ResponseEntity<List<DistributionListSubscriberMap>> getAllDlsForSubscriberId(
//			@RequestParam(name = "poojadl", required = true) Long distributionListId) {
//		try {
//			DistributionList p = dlService.findDistributionList(distributionListId);
//			List<DistributionListSubscriberMap> pdlsmList = pdlsmRepository.findAllByPoojaDlId(p.getId());
//			return new ResponseEntity<>(pdlsmList, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
