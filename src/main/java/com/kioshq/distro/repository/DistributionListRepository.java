package com.kioshq.distro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.distro.entity.DistributionList;

@Repository
public interface DistributionListRepository extends CrudRepository<DistributionList, Long> {

}
