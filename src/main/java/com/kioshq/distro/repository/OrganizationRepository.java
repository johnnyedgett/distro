package com.kioshq.distro.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.distro.entity.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

}
