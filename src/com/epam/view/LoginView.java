package com.epam.view;

import static com.epam.constants.Constants.Login.*;


import java.util.Scanner;

import com.epam.controller.LoginController;
import com.epam.model.User;

public class LoginView {
	
	private LoginController loginController;
	private ApplicationView appView;
	
	
	void launchApplication() {
		Scanner inputReader = new Scanner(System.in);
		System.out.println("Covid Vaccination Portal\n========================");
		System.out.print("1.Login\n2.Close\n\nPlease Enter your choice:");
		int choice = inputReader.nextInt();
		switch (choice) {
		case LOGIN:
			login();
			break;
		case CLOSEAPP:
			System.out.println("\n!---Closed The Application---!");
			break;
		default:
			System.out.println("Not a Valid Option");
		}
		inputReader.close();
	}
	
	void login() {
		Scanner readInput = new Scanner(System.in);
		System.out.print("\nEnter your registered aadharNumber:");
		String aadharCardNumber = readInput.next();
		loginController = new LoginController();
		User user = loginController.isRegisteredUser(aadharCardNumber);
		if(user==null)
			System.out.println("\n!---Invalid Aadhar Card Number--!");
		else
			applicationView(user);
		readInput.close();
	}
	void applicationView(User user) {
	   System.out.println("\nLogged In Successfully:"+user.getUserName());
	   appView = new ApplicationView();
	   appView.readUserInputView();
	}
	

}
