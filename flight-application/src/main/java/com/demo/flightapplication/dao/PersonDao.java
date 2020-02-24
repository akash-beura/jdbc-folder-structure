package com.demo.flightapplication.dao;

import java.util.List;

import com.demo.flightapplication.entity.Person;
import com.demo.flightapplication.exception.dao.FlightAppDaoException;

public interface PersonDao {

	int registerPerson(Person person) throws FlightAppDaoException;

	List<Person> getFilteredPersons() throws FlightAppDaoException;

	List<Person> getFilteredPersonsV2() throws FlightAppDaoException;

}
