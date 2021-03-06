package org.bidding.web.controllers.api;

import java.util.List;

import org.bidding.business.models.UserRole;
import org.bidding.business.services.interfaces.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class UserRoleController {

	@Autowired
	private IUserRoleService userRoleService;

	@RequestMapping("/user_roles")
	public @ResponseBody List<UserRole> getAllRoles() {
		return userRoleService.getAllRoles();
	}
	
	@RequestMapping("/user_roles/{id}")
	public @ResponseBody UserRole getRoleById(@PathVariable final Integer id) {
		return userRoleService.getRoleById(id);
	}
	
	@RequestMapping("/user_roless/role/{name}")
	public @ResponseBody UserRole getRoleByName(@PathVariable String name) {
		return userRoleService.getRoleByName(name);
	}
}