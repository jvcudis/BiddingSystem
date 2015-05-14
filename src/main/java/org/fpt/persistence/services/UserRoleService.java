package org.fpt.persistence.services;

import java.util.List;

import org.fpt.persistence.dao.IUserRoleDao;
import org.fpt.persistence.models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRoleService {
	
	@Autowired
	private IUserRoleDao userRoleDao;
	
	public UserRoleService() {
		
	}
	
	@Transactional
	public List<UserRole> getRoles() {
		return userRoleDao.getAllRoles();
	}
}