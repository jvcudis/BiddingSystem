package org.fpt.orm.services.interfaces;

import java.util.List;

import org.fpt.orm.dao.common.IOperations;
import org.fpt.orm.models.User;
import org.fpt.web.forms.UserForm;

public interface IUserService extends IOperations<User> {

	// TODO Add method description later
	
	List<User> getAllUsers();
	List<User> getAllUsersWithRole(Integer roleId);
	User getUserById(Integer id);
	User getUserByUsername(String name);
	User createUser(UserForm form);
	User updateUser(Integer id, UserForm form);
	User deleteUserById(Integer id);

}