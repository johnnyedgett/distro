package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.User;

@Repository
public interface AuthenticationRepository extends CrudRepository<User, Long> {

}
