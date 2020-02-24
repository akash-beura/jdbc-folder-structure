package com.demo.flightapplication.exception.service;

import com.demo.flightapplication.exception.dao.FlightAppDaoException;

public class FlightAppServiceException extends FlightAppDaoException {

	public FlightAppServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightAppServiceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FlightAppServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FlightAppServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FlightAppServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
