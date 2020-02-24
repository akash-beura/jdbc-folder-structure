package com.demo.flightapplication.service.impl;

import java.util.List;

import com.demo.flightapplication.dao.FlightDao;
import com.demo.flightapplication.dao.impl.FlightDaoImpl;
import com.demo.flightapplication.entity.Flight;
import com.demo.flightapplication.exception.dao.FlightAppDaoException;
import com.demo.flightapplication.exception.service.FlightAppServiceException;
import com.demo.flightapplication.service.FlightService;



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
