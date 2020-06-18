package com.kioshq.poojadl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.poojadl.service.DistributionListService;
import com.kioshq.poojadl.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

//	private static final Logger LOG = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	SubscriptionService subscriptionService;

	@Autowired
	DistributionListService dlService;

//	@PostMapping("/create")
//	public ResponseEntity<DistributionListSubscriberMap> createSubscription(@RequestBody SubscriptionTemplate subscription,
//			@RequestParam(name = "poojadl", required = true) Long poojaDlId) {
//		Subscription newSubscription = subscriptionService.createNewSubscription(subscription);
//		
//
//		DistributionListSubscriberMap toSave = new DistributionListSubscriberMap(s.getId(), poojaDl.getId());
//
//		DistributionListSubscriberMap pdlsm = pdlsmRepository.save(toSave);
//
//		return new ResponseEntity<>(pdlsm, HttpStatus.CREATED);
//	}

	// Get all dl for subscriber id
//	@GetMapping("/get")
//	public ResponseEntity<List<DistributionListSubscriberMap>> getAllDlsForSubscriberId(
//			@RequestParam(name = "subscription", required = true) Long subscriptionId) {
//		try {
//			Subscription s = subscriptionService.findById(subscriptionId).get();
////			List<DistributionListSubscriberMap> pdlsmList = pdlsmRepository.findAllBySubscriberId(s.getId());
//			return new ResponseEntity<>(pdlsmList, HttpStatus.OK);
//		} catch (NoSuchElementException e) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//	}
}
