package com.kioshq.poojadl.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
import com.kioshq.poojadl.repository.PoojaDLRepository;
import com.kioshq.poojadl.repository.PoojaDLSubscriberMapRepository;

@RestController
@RequestMapping("/api/poojadl")
public class PoojaDLController {

	@Autowired
	PoojaDLRepository poojaDlRepository;

	@Autowired
	PoojaDLSubscriberMapRepository pdlsmRepository;

	@GetMapping("/all")
	public List<PoojaDL> getAllPoojaDL() {
		List<PoojaDL> responseList = new ArrayList<>();
		Iterable<PoojaDL> iterable = poojaDlRepository.findAll();
		iterable.forEach(responseList::add);
		return responseList;
	}

	@PostMapping("/create")
	public PoojaDL createPoojaDL(@RequestBody PoojaDL poojaDl) {
		return poojaDlRepository.save(poojaDl);
	}

	// Get all subscriber id for dl id
	@GetMapping("/get")
	public ResponseEntity<List<PoojaDLSubscriberMap>> getAllDlsForSubscriberId(
			@RequestParam(name = "poojadl", required = true) Long poojaDlId) {
		try {
			PoojaDL p = poojaDlRepository.findById(poojaDlId).get();
			List<PoojaDLSubscriberMap> pdlsmList = pdlsmRepository.findAllByPoojaDlId(p.getId());
			return new ResponseEntity<>(pdlsmList, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
