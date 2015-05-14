package org.fpt.web.controllers.api;

import org.fpt.persistence.models.User;
import org.fpt.persistence.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
	
	@Autowired
	private AuthenticationService authService;
	
	@RequestMapping("/authenticate")
	public User authenticate(String username, String password) {
		User details = authService.authenticateUser(username, password);
		return details;
	}
}