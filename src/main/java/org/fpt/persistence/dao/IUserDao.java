package org.fpt.persistence.dao;

import java.util.List;

import org.fpt.persistence.models.User;

public interface IUserDao {
	
	List<User> getAllUsers();
	User findUserById(Integer id);
	User findUserByUsername(String email);
  
}