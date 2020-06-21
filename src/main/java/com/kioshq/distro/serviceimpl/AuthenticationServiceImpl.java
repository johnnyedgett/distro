package com.kioshq.distro.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kioshq.distro.dto.UserTemplate;
import com.kioshq.distro.entity.User;
import com.kioshq.distro.repository.AuthenticationRepository;
import com.kioshq.distro.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	AuthenticationRepository authenticationRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public User registerNewUser(UserTemplate newUser) {
		if (!validateUser(newUser))
			throw new IllegalArgumentException("PH ERROR TODO");

		User user = new User();
		user.setUsername(newUser.getUsername());
		user.setPassword(passwordEncoder.encode(newUser.getPassword()));
		user.setSubscriptions(new ArrayList<>());
		user.setOrganizations(new ArrayList<>());

		// TODO check if this person exists etc.
		return authenticationRepository.save(user);
	}

	@Override
	public User loginUser(UserTemplate user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUser(Long userId) {
		return authenticationRepository.findById(userId).get();
	}

	@Override
	public boolean validateUser(UserTemplate user) {
		return (authenticationRepository.findByUsername(user.getUsername()) == null);
	}
}
