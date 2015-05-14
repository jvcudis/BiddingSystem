package org.fpt.persistence.dao;

import java.util.List;

import org.fpt.persistence.models.UserRole;


public interface IUserRoleDao {
	
	List<UserRole> getAllRoles();
	String getRoleName(Integer role_id);
	
  
}