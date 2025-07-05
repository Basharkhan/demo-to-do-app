package com.khan.demo_to_do_app.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("khan");
		boolean isValidPassword = password.equalsIgnoreCase("khan");
		
		return isValidUsername && isValidPassword;
	}
}
