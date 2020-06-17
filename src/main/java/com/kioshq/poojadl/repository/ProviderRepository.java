package com.kioshq.poojadl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kioshq.poojadl.entity.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long>{

}
