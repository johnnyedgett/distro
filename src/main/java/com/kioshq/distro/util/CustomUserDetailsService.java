package com.kioshq.distro.util;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kioshq.distro.entity.Person;
import com.kioshq.distro.repository.AuthenticationRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	AuthenticationRepository authRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Person> u = authRepository.findByUsername(username);
		if (u.isPresent())
			return UserPrincipal.create(u.get());
		else
			throw new IllegalArgumentException("PH - Unable to get the user from repo");
	}
}
