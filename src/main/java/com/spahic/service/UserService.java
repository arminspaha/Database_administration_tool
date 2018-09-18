package com.spahic.service;

import java.util.List;

import com.spahic.entity.User;

public interface UserService {

	List<User> getUsers();

	User getUser(int userId);

	void saveUser(User theUser);

	void deleteUser(int userId);

}
