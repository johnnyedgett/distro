package com.kioshq.poojadl.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToMany
	private Set<PoojaDL> poojaDlList;

	private String name;

	public Set<PoojaDL> getPoojaDlList() {
		return poojaDlList;
	}

	public void setPoojaDlList(Set<PoojaDL> poojaDlList) {
		this.poojaDlList = poojaDlList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
}
