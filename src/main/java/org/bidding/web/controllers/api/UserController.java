package org.bidding.web.controllers.api;

import java.util.List;

import org.bidding.business.models.User;
import org.bidding.business.services.interfaces.IUserService;
import org.bidding.web.forms.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Preconditions;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private IUserService userService;

	/**
     * Returns all users.
     * 
     * @return A list of users in JSON format if there are users found.
     *         An empty list if there are no users found.
     */
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
		Preconditions.checkNotNull(resource);
		return userService.createUser(resource);
    }
	
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	@ResponseStatus(HttpStatus.OK)
    public User updateUser(@PathVariable final Integer id, @RequestBody final UserForm resource) {
		Preconditions.checkNotNull(resource);
		return userService.updateUser(id, resource);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	@ResponseStatus(HttpStatus.OK)
    public User deleteUser(@PathVariable final Integer id) {
		return userService.deleteUserById(id);
    }
	
}