package com.kioshq.distro.entity;

import javax.persistence.CascadeType;
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
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference(value = "user-subscriptions")
	private User user;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DistributionList getDistributionList() {
		return distributionList;
	}

	public void setDistributionList(DistributionList distributionList) {
		this.distributionList = distributionList;
	}

	public Subscription() {
	}

	public Subscription(User user, DistributionList distributionList, SubscriptionType subscriptionType) {
		this.user = user;
		this.distributionList = distributionList;
		this.subscriptionType = subscriptionType;
	}
}