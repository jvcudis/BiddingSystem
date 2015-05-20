package org.fpt.orm.dao.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.User;
import org.fpt.web.forms.UserForm;

public interface IUserDao extends IOperations<User> {
	
	// TODO Add method description later
	
	List<User> findUsersWithRole(Integer roleId);
	User findUserByUsername(String username);
	User createUser(UserForm form);
	User updateUser(Integer id, UserForm form);
	
}
