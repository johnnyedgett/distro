package com.kioshq.poojadl.entity;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PoojaDL {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String dlName;

	@OneToMany
	private Set<Subscriber> subscribers;

	@ElementCollection(targetClass = String.class)
	private Set<String> categories;

	public PoojaDL() {
	}

	public Set<Subscriber> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(Set<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	public Long getId() {
		return id;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public String getDlName() {
		return dlName;
	}

	public void setDlName(String dlName) {
		this.dlName = dlName;
	}
}
