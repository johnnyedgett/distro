package com.kioshq.poojadl.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private Set<PoojaDL> poojaDlList;

	private String email;
	@JsonProperty(access=Access.WRITE_ONLY)
	private String password;
	private String providerName;

	public Set<PoojaDL> getPoojaDlList() {
		return poojaDlList;
	}

	public void setPoojaDlList(Set<PoojaDL> poojaDlList) {
		this.poojaDlList = poojaDlList;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}	
	
	public Provider () {}
	
	public Provider (Provider provider) {
		this.email = provider.getEmail();
		this.providerName = provider.getProviderName();
	}
}
