package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.PoojaDL;

@Repository
public interface PoojaDLRepository extends CrudRepository<PoojaDL, Long> {

}
