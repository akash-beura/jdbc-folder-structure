package com.mindtree.flightapplication.service;

import java.util.List;

import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.exception.service.FlightAppServiceException;

public interface FlightService {
	int registerFlight(Flight flight) throws FlightAppServiceException;

	List<Flight> getAllFlights() throws FlightAppServiceException;

	public int bookFlight(int personId, int flightId) throws FlightAppServiceException;
}
