package com.epam.model;

public class User {

	private String userRole;
	private String userName;
	private String aadharCardNumber;
	private int age;
	private boolean isUserVaccinated;
	private int vaccineShotCount;
	private String shotOneVaccinatedDate;
	private String shotTwoVaccinatedDate;

	public User() {
		this.isUserVaccinated = false;
		this.userRole = "user";
		this.vaccineShotCount = 0;
		this.shotOneVaccinatedDate = "Not Yet";
		this.shotTwoVaccinatedDate = "Not Yet";
	}

	public User(String userName, String aadharCardNumber, int age) {
		this.userName = userName;
		this.aadharCardNumber = aadharCardNumber;
		this.age = age;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAadharCardNumber() {
		return aadharCardNumber;
	}

	public void setAadharCardNumber(String aadharCardNumber) {
		this.aadharCardNumber = aadharCardNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isUserVaccinated() {
		return isUserVaccinated;
	}

	public void setUserVaccinated(boolean isUserVaccinated) {
		this.isUserVaccinated = isUserVaccinated;
	}

	public int getVaccineShotCount() {
		return vaccineShotCount;
	}

	public void setVaccineShotCount(int vaccineShotCount) {
		this.vaccineShotCount = vaccineShotCount;
	}

	public String getShotOneVaccinatedDate() {
		return shotOneVaccinatedDate;
	}

	public void setShotOneVaccinatedDate(String shotOneVaccinatedDate) {
		this.shotOneVaccinatedDate = shotOneVaccinatedDate;
	}

	public String getShotTwoVaccinatedDate() {
		return shotTwoVaccinatedDate;
	}

	public void setShotTwoVaccinatedDate(String shotTwoVaccinatedDate) {
		this.shotTwoVaccinatedDate = shotTwoVaccinatedDate;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", aadharCardNumber=" + aadharCardNumber + ", age=" + age
				+ ", isUserVaccinated=" + isUserVaccinated + ", vaccineShotCount=" + vaccineShotCount + "]";
	}

}