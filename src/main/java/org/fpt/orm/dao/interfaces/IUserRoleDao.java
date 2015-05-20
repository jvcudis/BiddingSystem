package org.fpt.orm.dao.interfaces;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.UserRole;

public interface IUserRoleDao extends IOperations<UserRole> {
    
	// TODO Add method description later
	UserRole findRoleByName(String name);
	
}
