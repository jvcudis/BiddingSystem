package org.fpt.persistence.dao;

import java.util.List;

import org.fpt.persistence.model.UserRole;


public interface UserRoleDao {
	
	List<UserRole> getAllRoles();
	String getRoleName(Integer role_id);
	
  
}