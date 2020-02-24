package com.demo.flightapplication.dao;

import java.util.List;

import com.demo.flightapplication.entity.Flight;
import com.demo.flightapplication.exception.dao.FlightAppDaoException;

public interface FlightDao {

	int registerFlight(Flight flight) throws FlightAppDaoException;

	List<Flight> getAllFlights() throws FlightAppDaoException;

	public int bookFlight(int personId, int flightId) throws FlightAppDaoException;

}
