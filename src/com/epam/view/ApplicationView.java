package com.epam.view;

import static com.epam.constants.Constants.Application.ADD_NEW_USER;
import static com.epam.constants.Constants.Application.CLOSEAPP;
import static com.epam.constants.Constants.Application.DISPLAY_VACCINE_STOCK;
import static com.epam.constants.Constants.Application.REGISTERED_USERS;
import static com.epam.constants.Constants.Application.UPDATE_VACCINE_STOCK;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.epam.controller.ApplicationController;
import com.epam.model.User;

public class ApplicationView {

	private ApplicationController appController;

	ApplicationView() {
		appController = new ApplicationController();
	}

	public void readUserInputView() {
		while (true) {
			System.out.println("\nApplication View\n================");
			System.out.println("\nPlease Enter Your Choice:");
			System.out.print(
					"\n1.List of Vaccinated Users\n2.Check & Vaccine User\n3.Display Vaccine Stock\n4.Update Vaccine Stock\n5.Close");
			System.out.print("\nPlease Enter Your Choice:");
			Scanner readUserInput = new Scanner(System.in);
			int choice = readUserInput.nextInt();
			switch (choice) {
			case REGISTERED_USERS:
				List<User> listOfUsers = appController.getListOfUsers();
				System.out.println("\nList Of Vaccinated Users\n========================");
				if (listOfUsers.size() >= 1)
					listOfUsers.forEach((user) -> System.out.println(user));
				else
					System.out.println("!---Still no one vaccinated Yet---!");
				break;
			case ADD_NEW_USER:
				System.out.print("\nPlease enter AadharCardNumber:");
				String aadharCardNumber = readUserInput.next();
				if (checkUserVaccineStatus(aadharCardNumber)) {
					User user = new User();
					System.out.print("Please enter your userName:");
					String userName = readUserInput.next();
					System.out.print("Please enter age:");
					int age = readUserInput.nextInt();
					user.setAadharCardNumber(aadharCardNumber);
					user.setUserName(userName);
					user.setAge(age);
					user.setUserVaccinated(true);
					user.setShotOneVaccinatedDate(LocalDateTime.now().toString());
					int count = user.getVaccineShotCount();
					user.setVaccineShotCount(count + 1);
					appController.addNewUser(user);
					System.out.println("\nUser Vaccinated his first Dose Successfully ");
					}
				break;
			case DISPLAY_VACCINE_STOCK:
				System.out.println("\nAvaliable Vaccine Count:" + appController.getAvaliableVaccineStock());
				break;
			case UPDATE_VACCINE_STOCK:
				System.out.print("\nEnter New Vaccine Count:");
				long newVaccineStockCount = readUserInput.nextLong();
				boolean status = appController.updateVaccineStock(newVaccineStockCount);
				if (status)
					System.out.println("\n Vaccine count has been Updated Successfully");
				break;
			case CLOSEAPP:
				System.out.println("\n!---------------Application Closed--------------!");
				readUserInput.close();
				System.exit(0);
				break;
			default:
				System.out.println("\nInvalid Option");
			}
		}

	}

	public boolean checkUserVaccineStatus(String aadharCardNumber) {
		List<User> listOfUsers = appController.getListOfUsers();
		if (listOfUsers.size() >= 0) {
			for (User user : listOfUsers) {
				if (user.getAadharCardNumber().equalsIgnoreCase(aadharCardNumber)) {
					if (user.getVaccineShotCount() == 1)
						{
						  System.out.println("\nThis Person has already vaccinated Dose 1 at this date and time:"+user.getShotOneVaccinatedDate());
						  user.setShotTwoVaccinatedDate(LocalDateTime.now().toString());
						  user.setVaccineShotCount(2);
						  appController.updateUserState(user);
						}
					else if (user.getVaccineShotCount() == 2)
						System.out.println("\nThis Person has Done with his 2 shots of vaccination");
					return false;
				}
			}
		}
		return true;
	}

}
