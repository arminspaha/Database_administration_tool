package com.spahic.dao;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;



@Repository
public class ProfileDaoImpl implements ProfileDao {
	
	/*@Autowired
	private SessionFactory sessionFactory;*/

	@Override
	public Set<String> getRoles() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		Set<String> roles = authentication.getAuthorities().stream()
		     .map(r -> r.getAuthority()).collect(Collectors.toSet());

		return roles;
	}

	@Override
	public Set<String> getUsername() {
		
		Set<String> userName = new HashSet<>();
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    
			userName.add(authentication.getName());
		    
		}
		
		return userName;
	}

	

}
