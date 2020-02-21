package com.mindtree.flightapplication.dao;

import java.util.List;

import com.mindtree.flightapplication.entity.Person;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;

public interface PersonDao {

	int registerPerson(Person person) throws FlightAppDaoException;

	List<Person> getFilteredPersons() throws FlightAppDaoException;

	List<Person> getFilteredPersonsV2() throws FlightAppDaoException;

}
