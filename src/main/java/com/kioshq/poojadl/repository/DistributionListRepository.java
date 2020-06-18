package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.DistributionList;

@Repository
public interface DistributionListRepository extends CrudRepository<DistributionList, Long> {

}
