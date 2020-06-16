package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.Subscriber;

@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long> {

}
