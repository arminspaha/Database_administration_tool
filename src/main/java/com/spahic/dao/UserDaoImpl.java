package com.spahic.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spahic.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<User> getUsers() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<User> theQuery =
				currentSession.createQuery("from User order by firstName", User.class);
		
		List<User> users = theQuery.getResultList();
		
		return users;
	}

	@Override
	public User getUser(int userId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		User user = currentSession.get(User.class, userId);
		
		return user;
	}

	@Override
	public void saveUser(User theUser) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		// save/update the user
		currentSession.saveOrUpdate(theUser);

	}

	@Override
	public void deleteUser(int userId) {
		
		Session currentSesison = sessionFactory.getCurrentSession();
		
		Query theQuery =
				currentSesison.createQuery("delete from User where userId=:userId");
		theQuery.setParameter("userId", userId);
		
		theQuery.executeUpdate();
		
	}

}
