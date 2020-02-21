package com.mindtree.flightapplication.dao;

import java.util.List;

import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;

public interface FlightDao {

	int registerFlight(Flight flight) throws FlightAppDaoException;

	List<Flight> getAllFlights() throws FlightAppDaoException;

	public int bookFlight(int personId, int flightId) throws FlightAppDaoException;

}
