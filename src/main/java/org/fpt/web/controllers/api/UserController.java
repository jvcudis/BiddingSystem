package org.fpt.web.controllers.api;

import java.util.List;

import org.fpt.orm.models.User;
import org.fpt.orm.services.interfaces.IUserService;
import org.fpt.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	public User getUserById(@PathVariable final Integer id) {
		return userService.getUserById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/role/{roleId}")
	public List<User> getAllUsersWithRole(@PathVariable final Integer roleId) {
		return userService.getAllUsersWithRole(roleId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody final UserForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return userService.createUser(resource);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	@ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable final Integer id, @RequestBody final UserForm resource) {
		// TODO Pre-checking conditions, resource must be valid
		return userService.updateUser(id, resource);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	@ResponseStatus(HttpStatus.OK)
    public User deleteUser(@PathVariable final Integer id) {
		return userService.deleteUserById(id);
    }
	
}