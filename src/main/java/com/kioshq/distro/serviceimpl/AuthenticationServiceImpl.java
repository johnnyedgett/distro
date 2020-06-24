package com.kioshq.distro.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kioshq.distro.dto.PersonTemplate;
import com.kioshq.distro.entity.Person;
import com.kioshq.distro.repository.AuthenticationRepository;
import com.kioshq.distro.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationRepository authenticationRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Person registerNewPerson(PersonTemplate newUser) {
		if (!validateUser(newUser))
			throw new IllegalArgumentException("PH ERROR TODO");

		Person person = new Person();
		person.setUsername(newUser.getUsername());
		person.setPassword(passwordEncoder.encode(newUser.getPassword()));
		person.setSubscriptions(new ArrayList<>());
		person.setOrganizations(new ArrayList<>());

		// TODO check if this person exists etc.
		return authenticationRepository.save(person);
	}

	@Override
	public Person loginUser(PersonTemplate person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person findUser(Long personId) {
		return authenticationRepository.findById(personId).get();
	}

	@Override
	public boolean validateUser(PersonTemplate person) {
		boolean personExists = authenticationRepository.findByUsername(person.getUsername()).isPresent();
		return !personExists;
	}
}
