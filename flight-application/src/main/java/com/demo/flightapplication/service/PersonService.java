package com.demo.flightapplication.service;

import java.util.List;

import com.demo.flightapplication.entity.Person;
import com.demo.flightapplication.exception.service.FlightAppServiceException;

public interface PersonService {
	int registerPerson(Person person) throws FlightAppServiceException;

	List<Person> getFilteredPersons() throws FlightAppServiceException;

	List<Person> getFilteredPersonsV2() throws FlightAppServiceException;
}
