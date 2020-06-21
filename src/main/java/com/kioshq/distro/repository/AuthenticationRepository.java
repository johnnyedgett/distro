package com.kioshq.distro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.distro.entity.User;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Long> {

	Optional<User> findByUsername(String username);

}
