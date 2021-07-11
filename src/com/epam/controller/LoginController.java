package com.epam.controller;

import com.epam.model.User;

public class LoginController {

	private User loginUser;

	public LoginController() {
		loginUser = new User();
		loginUser.setUserName("Rahul");
		loginUser.setUserRole("User");
		loginUser.setAge(23);
		loginUser.setAadharCardNumber("987654321987");
	}

	public User isRegisteredUser(String aadharCardNumber) {
		if (loginUser.getAadharCardNumber().equalsIgnoreCase(aadharCardNumber))
			return loginUser;
		else
			return null;
	}

}
