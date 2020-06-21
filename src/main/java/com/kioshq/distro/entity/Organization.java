package com.kioshq.distro.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "organization_id")
	private Long id;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "organization_id")
	@JsonBackReference(value = "user-distributionlists")
	private List<DistributionList> distributionLists;

	@ManyToMany
	@JoinTable(name = "user_organization", joinColumns = {
			@JoinColumn(name = "organization_id") }, inverseJoinColumns = { @JoinColumn(name = "user_id") })
	@JsonBackReference(value = "user-organizations")
	private List<User> users;

	private String providerName;

	public List<DistributionList> getDistributionLists() {
		return distributionLists;
	}

	public void setDistributionLists(List<DistributionList> distributionLists) {
		this.distributionLists = distributionLists;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Long getId() {
		return id;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Organization() {
	}

	public Organization(String name, List<User> users) {
		this.providerName = name;
		this.users = users;
		this.distributionLists = new ArrayList<>();
	}

}
