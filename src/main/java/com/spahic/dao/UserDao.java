package com.spahic.dao;

import java.util.List;

import com.spahic.entity.User;

public interface UserDao {

	List<User> getUsers();

	User getUser(int userId);

	void saveUser(User theUser);

	void deleteUser(int userId);

}
