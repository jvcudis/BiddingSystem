package org.bidding.business.dao.interfaces;

import java.util.List;

import org.bidding.business.dao.common.IOperations;
import org.bidding.business.models.User;
import org.bidding.web.forms.UserForm;

public interface IUserDao extends IOperations<User> {
	
	// TODO Add method description later
	
	List<User> findUsersWithRole(Integer roleId);
	User findUserByUsername(String username);
	User createUser(UserForm form);
	User updateUser(Integer id, UserForm form);
	
}
