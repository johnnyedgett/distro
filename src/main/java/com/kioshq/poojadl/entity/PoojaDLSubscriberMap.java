package com.kioshq.poojadl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PoojaDLSubscriberMap {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long poojaDlId;
	private Long subscriberId;
	public Long getPoojaDlId() {
		return poojaDlId;
	}
	public void setPoojaDlId(Long poojaDlId) {
		this.poojaDlId = poojaDlId;
	}
	public Long getSubscriberId() {
		return subscriberId;
	}
	public void setSubscriberId(Long subscriberId) {
		this.subscriberId = subscriberId;
	}
	public Long getId() {
		return id;
	}
	public PoojaDLSubscriberMap() {}
	public PoojaDLSubscriberMap(Long subscriberId, Long poojaDlId) {
		this.subscriberId = subscriberId;
		this.poojaDlId = poojaDlId;
	}
}
