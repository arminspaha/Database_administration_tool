package com.spahic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spahic.dao.UserDao;
import com.spahic.entity.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public List<User> getUsers() {
		return userDao.getUsers();
	}

	@Override
	@Transactional
	public User getUser(int userId) {
		return userDao.getUser(userId);
	}

	@Override
	@Transactional
	public void saveUser(User theUser) {
		userDao.saveUser(theUser);
		
	}

	@Override
	@Transactional
	public void deleteUser(int userId) {
		userDao.deleteUser(userId);
		
	}

}
