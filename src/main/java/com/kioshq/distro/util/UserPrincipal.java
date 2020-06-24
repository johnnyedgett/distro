package com.kioshq.distro.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kioshq.distro.entity.Person;

import com.kioshq.distro.util.UserPrincipal;

/* TODO flesh this out a bit */
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	private Person user;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public Person getUser(){
		return user;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public UserPrincipal(Long id, String username, String password, List<GrantedAuthority> authorities, Person user) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		
		// is this necessary? TODO
		this.user = user;
	}

	public static UserPrincipal create(Person u) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return new UserPrincipal(u.getId(), u.getUsername(), u.getPassword(), authorities, u);
	}

}
