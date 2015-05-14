package org.fpt.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import org.fpt.persistence.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession()
				.createQuery("from User")
				.list();
		
		if (users.size() > 0) {
			return users;
		} else {
			return null;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public User findUserById(Integer id) {
		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where id=?")
				.setParameter(0, id)
				.list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public User findUserByUsername(String email) {
		List<User> users = new ArrayList<User>();
		
		users = sessionFactory.getCurrentSession()
				.createQuery("from User where email=?")
				.setParameter(0, email)
				.list();
		
		if (users.size() > 0) {
			return users.get(0);
		} else {
			return null;
		}
	}

}