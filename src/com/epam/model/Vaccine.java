package com.epam.model;

public class Vaccine {

	private String vaccineName;
	private long vaccineCount;
	
	public Vaccine() {
	}

	public Vaccine(String vaccineName, int vaccineCount) {
		this.vaccineName = vaccineName;
		this.vaccineCount = vaccineCount;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public long getVaccineCount() {
		return vaccineCount;
	}

	public void setVaccineCount(long vaccineCount) {
		this.vaccineCount = vaccineCount;
	}

}