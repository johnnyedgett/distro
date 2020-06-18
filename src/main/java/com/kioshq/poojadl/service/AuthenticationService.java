package com.kioshq.poojadl.service;

import com.kioshq.poojadl.dto.UserTemplate;
import com.kioshq.poojadl.entity.User;

public interface AuthenticationService {
	User registerNewUser(UserTemplate user);

	User loginUser(UserTemplate user);

	User findUser(Long userId);

	boolean validateUser(UserTemplate user);
}
