package org.fpt.persistence.services;

import org.fpt.persistence.dao.IUserDao;
import org.fpt.persistence.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthenticationService {
	
	@Autowired
	private IUserDao userDao;
	
	public AuthenticationService() {
		
	}
	
	@Transactional
	public User authenticateUser(String username, String password) {
		
		// IMPROVE LATERZ, USE Spring Security
		User user = userDao.findUserByUsername(username);
		
		if(user.getRole().equals("ADMIN") && user.getPassword().equals(password)) {
			return user;
		} else {
			return null;
		}
	}
}