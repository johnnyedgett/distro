package com.kioshq.distro.service;

import com.kioshq.distro.dto.PersonTemplate;
import com.kioshq.distro.entity.Person;

public interface AuthenticationService {
	Person registerNewPerson(PersonTemplate user);

	Person loginUser(PersonTemplate user);

	Person findUser(Long userId);

	boolean validateUser(PersonTemplate user);
}
