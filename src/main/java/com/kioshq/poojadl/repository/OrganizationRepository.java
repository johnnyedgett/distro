package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
