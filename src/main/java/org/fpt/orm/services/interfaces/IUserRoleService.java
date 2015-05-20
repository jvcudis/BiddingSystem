package org.fpt.orm.services.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.UserRole;

public interface IUserRoleService extends IOperations<UserRole> {
    
	// TODO Add method description later
	
	List<UserRole> getAllRoles();
	UserRole getRoleById(Integer id);
	UserRole getRoleByName(String name);
	
}
