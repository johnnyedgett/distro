package com.kioshq.distro.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.distro.entity.Person;

@Repository
public interface AuthenticationRepository extends CrudRepository<Person, Long> {

	Optional<Person> findByUsername(String username);

}
