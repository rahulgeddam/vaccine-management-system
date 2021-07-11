package com.epam.dao;

import java.util.ArrayList;
import java.util.List;

import com.epam.model.User;
import com.epam.model.Vaccine;

public class Dao {

	private List<User> listOfUsers;
	private Vaccine vaccine;

	public Dao() {
		listOfUsers = new ArrayList<User>();
		vaccine = new Vaccine();
		vaccine.setVaccineCount(20);
		vaccine.setVaccineName("COVAXIN");
	}

	public List<User> fetchUsers() {
		return listOfUsers;
	}

	public void saveUser(User newUser) {
		listOfUsers.add(newUser);
	}

	public void updateExistingUser(User updatedUser) {
		for (User user : listOfUsers) {
		   if(user.getAadharCardNumber().equalsIgnoreCase(updatedUser.getAadharCardNumber())) {
			   user.setVaccineShotCount(updatedUser.getVaccineShotCount());
			   user.setShotTwoVaccinatedDate(updatedUser.getShotTwoVaccinatedDate());
		   }
		}
	}
	
	public long fetchExistingVaccineCount() {
		return vaccine.getVaccineCount();
	}

	public boolean updateExistingVaccineStock(long newVaccineStockCount) {
		vaccine.setVaccineCount(fetchExistingVaccineCount()+newVaccineStockCount);
		return true;
	}
}