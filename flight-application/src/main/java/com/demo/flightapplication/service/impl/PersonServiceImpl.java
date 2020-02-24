package com.demo.flightapplication.service.impl;

import java.util.List;

import com.demo.flightapplication.dao.PersonDao;
import com.demo.flightapplication.dao.impl.PersonDaoImpl;
import com.demo.flightapplication.entity.Person;
import com.demo.flightapplication.exception.dao.FlightAppDaoException;
import com.demo.flightapplication.exception.service.FlightAppServiceException;
import com.demo.flightapplication.service.PersonService;

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
