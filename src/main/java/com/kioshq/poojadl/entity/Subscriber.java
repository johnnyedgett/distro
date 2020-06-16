package com.kioshq.poojadl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscriber {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Type subscriberType;
	private String phoneNumber;
	private String emailAddress;
	
	public Type getSubscriberType() {
		return subscriberType;
	}
	public void setSubscriberType(Type subscriberType) {
		this.subscriberType = subscriberType;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public Long getId() {
		return id;
	}
	public Subscriber() {}
}

enum Type { PHONE, EMAIL };