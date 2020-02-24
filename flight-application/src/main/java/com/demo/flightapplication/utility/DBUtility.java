package com.demo.flightapplication.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.demo.flightapplication.exception.dao.FlightAppDaoException;

public class DBUtility {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	private static final String URL = "jdbc:mysql://localhost:3306/flightapplication?useSSL=false";

	private static Connection connection = null;

	public static Connection getConnection() throws FlightAppDaoException {

		try {
			if (connection == null || connection.isClosed()) {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
		} catch (ClassNotFoundException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		}
		return connection;
	}

	public static boolean closeConnection() throws FlightAppDaoException {
		boolean connectionClosed = false;
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
				connectionClosed = true;
			}
		} catch (SQLException e) {
			throw new FlightAppDaoException(e.getMessage(), e);
		}
		return connectionClosed;
	}

}
