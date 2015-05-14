package org.fpt.web.controllers.api;

import java.util.List;

import org.fpt.persistence.models.UserRole;
import org.fpt.persistence.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRoleController {

	@Autowired
	private UserRoleService roleService;

	@RequestMapping("/user_roles")
	public List<UserRole> getUserRoles() {
		return roleService.getRoles();
	}
	
}