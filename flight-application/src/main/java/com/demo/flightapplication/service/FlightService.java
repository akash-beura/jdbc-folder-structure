package com.demo.flightapplication.service;

import java.util.List;

import com.demo.flightapplication.entity.Flight;
import com.demo.flightapplication.exception.service.FlightAppServiceException;

public interface FlightService {
	int registerFlight(Flight flight) throws FlightAppServiceException;

	List<Flight> getAllFlights() throws FlightAppServiceException;

	public int bookFlight(int personId, int flightId) throws FlightAppServiceException;
}
