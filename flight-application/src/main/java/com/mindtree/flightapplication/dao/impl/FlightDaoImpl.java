package com.mindtree.flightapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.flightapplication.dao.FlightDao;
import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;
import com.mindtree.flightapplication.utility.DBUtility;

public class FlightDaoImpl implements FlightDao {

	private Connection connection = null;

	public int registerFlight(Flight flight) throws FlightAppDaoException {

		int result = 0;
		connection = DBUtility.getConnection();
		String query = "insert into flight values(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, flight.getFlightId());
			preparedStatement.setString(2, flight.getFlightName());
			preparedStatement.setFloat(3, flight.getTicketCost());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return result;

	}

	public List<Flight> getAllFlights() throws FlightAppDaoException {
		List<Flight> flights = new ArrayList<Flight>();
		connection = DBUtility.getConnection();
		String query = "select * from flight";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Flight flight = new Flight();
				flight.setFlightId(rs.getInt(1));
				flight.setFlightName(rs.getString(2));
				flight.setTicketCost(rs.getFloat(3));
				flights.add(flight);
			}

		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return flights;
	}

	private int updatePersonSalary(int personId, int flightId) throws FlightAppDaoException {
		int result = 0;
		connection = DBUtility.getConnection();
		String query = "update person set person_balance = person-balance - ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setFloat(1, getFlightCost(flightId));
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return result;
	}

	private float getFlightCost(int flightId) throws FlightAppDaoException {
		float result = 0;

		connection = DBUtility.getConnection();
		String query = "select * from flight where flight_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, flightId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				result = rs.getFloat(1);
			}
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return result;
	}

	public int bookFlight(int personId, int flightId) throws FlightAppDaoException {
		int result = 0;
		connection = DBUtility.getConnection();

		String query = "update person set flight_id = ? where person_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, flightId);
			preparedStatement.setInt(2, personId);
			result = preparedStatement.executeUpdate();
			result = updatePersonSalary(personId, flightId);
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return result;

	}

}
