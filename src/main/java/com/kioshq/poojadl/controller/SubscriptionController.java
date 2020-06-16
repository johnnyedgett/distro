package com.kioshq.poojadl.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kioshq.poojadl.entity.PoojaDL;
import com.kioshq.poojadl.entity.PoojaDLSubscriberMap;
import com.kioshq.poojadl.entity.Subscriber;
import com.kioshq.poojadl.repository.PoojaDLRepository;
import com.kioshq.poojadl.repository.PoojaDLSubscriberMapRepository;
import com.kioshq.poojadl.repository.SubscriberRepository;

@RestController
@RequestMapping("/api/subscription")
public class SubscriptionController {

	private static final Logger LOG = LoggerFactory.getLogger(SubscriptionController.class);

	@Autowired
	SubscriberRepository subscriberRepository;

	@Autowired
	PoojaDLRepository poojaDlRepository;

	@Autowired
	PoojaDLSubscriberMapRepository pdlsmRepository;

	@PostMapping("/create")
	public ResponseEntity<PoojaDLSubscriberMap> createSubscription(@RequestBody Subscriber subscriber,
			@RequestParam(name = "poojadl", required = true) Long poojaDlId) {
		Subscriber s = subscriberRepository.save(subscriber);
		PoojaDL poojaDl = poojaDlRepository.findById(poojaDlId).get();

		LOG.info(String.valueOf(s.getId()));
		LOG.info(String.valueOf(poojaDl.getId()));

		PoojaDLSubscriberMap toSave = new PoojaDLSubscriberMap(s.getId(), poojaDl.getId());

		PoojaDLSubscriberMap pdlsm = pdlsmRepository.save(toSave);

		return new ResponseEntity<>(pdlsm, HttpStatus.CREATED);
	}

	// Get all dl for subscriber id
	@GetMapping("/get")
	public ResponseEntity<List<PoojaDLSubscriberMap>> getAllDlsForSubscriberId(
			@RequestParam(name = "subscriber", required = true) Long subscriberId) {
		try {
			Subscriber s = subscriberRepository.findById(subscriberId).get();
			List<PoojaDLSubscriberMap> pdlsmList = pdlsmRepository.findAllBySubscriberId(s.getId());
			return new ResponseEntity<>(pdlsmList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
