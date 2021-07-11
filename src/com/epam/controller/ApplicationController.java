package com.epam.controller;

import java.util.List;

import com.epam.dao.Dao;
import com.epam.model.User;

public class ApplicationController {

	public Dao dao;

	public ApplicationController() {
		dao = new Dao();
	}

	public List<User> getListOfUsers() {
		return dao.fetchUsers();
	}

	public void addNewUser(User user) {
		dao.saveUser(user);
	}
	
	public void updateUserState(User user) {
		dao.updateExistingUser(user);
	}

	
	public long getAvaliableVaccineStock() {
		return dao.fetchExistingVaccineCount();
	}

	public boolean updateVaccineStock(long newVaccineStockCount) {
		return dao.updateExistingVaccineStock(newVaccineStockCount);
	}

}