package com.mindtree.flightapplication.service.impl;

import java.util.List;

import com.mindtree.flightapplication.dao.PersonDao;
import com.mindtree.flightapplication.dao.impl.PersonDaoImpl;
import com.mindtree.flightapplication.entity.Person;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;
import com.mindtree.flightapplication.exception.service.FlightAppServiceException;
import com.mindtree.flightapplication.service.PersonService;

public class PersonServiceImpl implements PersonService {

	private PersonDao personDao = new PersonDaoImpl();

	@Override
	public int registerPerson(Person person) throws FlightAppServiceException {
		try {
			return personDao.registerPerson(person);
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Person> getFilteredPersons() throws FlightAppServiceException {
		try {
			return personDao.getFilteredPersons();
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Person> getFilteredPersonsV2() throws FlightAppServiceException {
		try {
			return personDao.getFilteredPersonsV2();
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

}
