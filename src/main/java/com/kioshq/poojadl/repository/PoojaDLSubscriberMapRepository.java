package com.kioshq.poojadl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.PoojaDLSubscriberMap;

@Repository
public interface PoojaDLSubscriberMapRepository extends CrudRepository<PoojaDLSubscriberMap, Long> {
	List<PoojaDLSubscriberMap> findAllBySubscriberId(Long subscriberId);

	List<PoojaDLSubscriberMap> findAllByPoojaDlId(Long poojaDlId);
}
