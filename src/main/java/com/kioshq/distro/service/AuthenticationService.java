package com.kioshq.distro.service;

import com.kioshq.distro.dto.UserTemplate;
import com.kioshq.distro.entity.User;

public interface AuthenticationService {
	User registerNewUser(UserTemplate user);

	User loginUser(UserTemplate user);

	User findUser(Long userId);

	boolean validateUser(UserTemplate user);
}
