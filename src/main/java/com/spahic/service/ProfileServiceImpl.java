package com.spahic.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spahic.dao.ProfileDao;

@Service
public class ProfileServiceImpl implements ProfileService {
	
	@Autowired
	private ProfileDao profileDao;

	@Override
	@Transactional
	public Set<String> getRoles() {
		return profileDao.getRoles();
	}

	@Override
	@Transactional
	public Set<String> getUsername() {
		return profileDao.getUsername();
	}

}
