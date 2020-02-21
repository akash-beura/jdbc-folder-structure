package com.mindtree.flightapplication.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mindtree.flightapplication.dao.FlightDao;
import com.mindtree.flightapplication.dao.PersonDao;
import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.entity.Person;
import com.mindtree.flightapplication.exception.dao.FlightAppDaoException;
import com.mindtree.flightapplication.utility.DBUtility;

public class PersonDaoImpl implements PersonDao {
	private Connection connection = null;
	private FlightDao flightDao = new FlightDaoImpl();

	public int registerPerson(Person person) throws FlightAppDaoException {
		int result = 0;
		connection = DBUtility.getConnection();
		String query = "insert into person(person_id, person_name, person_balance) values(?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, person.getPersonId());
			preparedStatement.setString(2, person.getPersonName());
			preparedStatement.setFloat(3, person.getBankBalance());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return result;

	}

	public List<Person> getFilteredPersons() throws FlightAppDaoException {
		List<Person> persons = new ArrayList<Person>();
		List<Flight> flights = flightDao.getAllFlights();
		connection = DBUtility.getConnection();
		String query = "select * from person where person_balance > 50000";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Person person = new Person();
				person.setPersonId(rs.getInt(1));
				person.setPersonName(rs.getString(2));
				person.setBankBalance(rs.getFloat(3));
				for (Flight flight : flights) {
					if (flight.getFlightId() == rs.getFloat(4)) {
						person.setFlight(flight);
					}
				}
				persons.add(person);
			}

		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return persons;
	}

	public List<Person> getFilteredPersonsV2() throws FlightAppDaoException {
		List<Person> persons = new ArrayList<Person>();
		List<Flight> flights = flightDao.getAllFlights();
		connection = DBUtility.getConnection();
		String query = "select * from person";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				if (rs.getFloat(3) > 50000) {
					Person person = new Person();
					person.setPersonId(rs.getInt(1));
					person.setPersonName(rs.getString(2));
					person.setBankBalance(rs.getFloat(3));
					for (Flight flight : flights) {
						if (flight.getFlightId() == rs.getFloat(4)) {
							flights.add(flight);
						}
					}
				}
			}

		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} finally {
			DBUtility.closeConnection();
		}
		return persons;
	}

}
