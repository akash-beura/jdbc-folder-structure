package com.mindtree.flightapplication.service;

import java.util.List;

import com.mindtree.flightapplication.entity.Person;
import com.mindtree.flightapplication.exception.service.FlightAppServiceException;

public interface PersonService {
	int registerPerson(Person person) throws FlightAppServiceException;

	List<Person> getFilteredPersons() throws FlightAppServiceException;

	List<Person> getFilteredPersonsV2() throws FlightAppServiceException;
}
