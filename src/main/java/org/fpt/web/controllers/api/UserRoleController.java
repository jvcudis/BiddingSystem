package org.fpt.web.controllers.api;

import java.util.List;

import org.fpt.orm.models.UserRole;
import org.fpt.orm.services.interfaces.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user_roles")
public class UserRoleController {

	@Autowired
	private IUserRoleService userRoleService;

	@RequestMapping
	public @ResponseBody List<UserRole> getAllRoles() {
		return userRoleService.getAllRoles();
	}
	
	@RequestMapping("/{id}")
	public @ResponseBody UserRole getRoleById(@PathVariable final Integer id) {
		return userRoleService.getRoleById(id);
	}
	
	@RequestMapping("/role/{name}")
	public @ResponseBody UserRole getRoleByName(@PathVariable String name) {
		return userRoleService.getRoleByName(name);
	}
}