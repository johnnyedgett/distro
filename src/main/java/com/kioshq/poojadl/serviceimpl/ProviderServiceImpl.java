package com.kioshq.poojadl.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kioshq.poojadl.entity.Provider;
import com.kioshq.poojadl.repository.ProviderRepository;
import com.kioshq.poojadl.service.ProviderService;

@Service
public class ProviderServiceImpl implements ProviderService {
	@Autowired
	ProviderRepository providerRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public Provider registerProvider(Provider provider) { 
		Provider p = new Provider(provider);
		p.setPassword(passwordEncoder.encode(provider.getPassword()));
		
		// TODO check if this person exists etc.
		return providerRepository.save(p);
	}
}
