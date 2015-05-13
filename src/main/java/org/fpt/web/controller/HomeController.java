package org.fpt.web.controller;

import org.fpt.persistence.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private UserRoleService roleService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayHome() {
		return "/index";
	}
}