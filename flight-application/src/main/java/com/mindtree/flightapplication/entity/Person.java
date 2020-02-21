package com.mindtree.flightapplication.entity;

public class Person {

	private int personId;
	private String personName;
	private float bankBalance;
	private Flight flight;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public float getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(float bankBalance) {
		this.bankBalance = bankBalance;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
