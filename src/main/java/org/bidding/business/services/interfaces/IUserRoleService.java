package org.bidding.business.services.interfaces;

import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.UserRole;

public interface IUserRoleService extends IOperations<UserRole> {
    
	// TODO Add method description later
	
	List<UserRole> getAllRoles();
	UserRole getRoleById(Integer id);
	UserRole getRoleByName(String name);
	
}
