package org.bidding.business.dao.interfaces;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.UserRole;

public interface IUserRoleDao extends IOperations<UserRole> {
    
	// TODO Add method description later
	UserRole findRoleByName(String name);
	
}
