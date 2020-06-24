package com.kioshq.distro.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_id")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	@JsonBackReference(value = "person-subscriptions")
	private Person person;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "distribution_list_id")
	@JsonManagedReference(value = "subscription-distributionList")
	private DistributionList distributionList;

	private SubscriptionType subscriptionType;

	public SubscriptionType getSubscriberType() {
		return subscriptionType;
	}

	public void setSubscriberType(SubscriptionType subscriberType) {
		this.subscriptionType = subscriberType;
	}

	public Long getId() {
		return id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public DistributionList getDistributionList() {
		return distributionList;
	}

	public void setDistributionList(DistributionList distributionList) {
		this.distributionList = distributionList;
	}

	public Subscription() {
	}

	public Subscription(Person person, DistributionList distributionList, SubscriptionType subscriptionType) {
		this.person = person;
		this.distributionList = distributionList;
		this.subscriptionType = subscriptionType;
	}
}