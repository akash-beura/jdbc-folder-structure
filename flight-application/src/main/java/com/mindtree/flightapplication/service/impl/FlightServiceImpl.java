package com.mindtree.flightapplication.service.impl;

import java.util.List;

import com.mindtree.flightapplication.dao.FlightDao;
import com.mindtree.flightapplication.dao.impl.FlightDaoImpl;
import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;
import com.mindtree.flightapplication.exception.service.FlightAppServiceException;
import com.mindtree.flightapplication.service.FlightService;



public class FlightServiceImpl implements FlightService {

	private FlightDao flightDao = new FlightDaoImpl();

	@Override
	public int registerFlight(Flight flight) throws FlightAppServiceException {
		try {
			return flightDao.registerFlight(flight);
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public List<Flight> getAllFlights() throws FlightAppServiceException {
		try {
			return flightDao.getAllFlights();
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

	@Override
	public int bookFlight(int personId, int flightId) throws FlightAppServiceException {
		try {
			return flightDao.bookFlight(personId, flightId);
		} catch (FlightAppDaoException e) {
			throw new FlightAppServiceException(e.getMessage(), e);
		}
	}

}
