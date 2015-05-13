package org.fpt.persistence.service;

import java.util.List;

import org.fpt.persistence.dao.UserRoleDao;
import org.fpt.persistence.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	public UserRoleService() {
		
	}
	
	@Transactional
	public List<UserRole> getRoles() {
		return userRoleDao.getAllRoles();
	}
}