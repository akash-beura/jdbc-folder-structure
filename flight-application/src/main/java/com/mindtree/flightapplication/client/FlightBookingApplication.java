package com.mindtree.flightapplication.client;

import java.util.List;
import java.util.Scanner;

import com.mindtree.flightapplication.entity.Flight;
import com.mindtree.flightapplication.entity.Person;
import com.mindtree.flightapplication.exception.FlighApplicationException;
import com.mindtree.flightapplication.exception.service.FlightAppServiceException;
import com.mindtree.flightapplication.service.FlightService;
import com.mindtree.flightapplication.service.PersonService;
import com.mindtree.flightapplication.service.impl.FlightServiceImpl;
import com.mindtree.flightapplication.service.impl.PersonServiceImpl;

public class FlightBookingApplication {

	private static FlightService flightService = new FlightServiceImpl();
	private static PersonService personService = new PersonServiceImpl();
	private static Scanner sc = new Scanner(System.in);

	private static int getInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static float getFloat() {
		Scanner sc = new Scanner(System.in);
		return sc.nextFloat();
	}

	private static String getString() {
		return sc.nextLine();
	}

	private static Flight getFlightData() {

		Flight flight = new Flight();
		System.out.println("Enter flight Id");
		flight.setFlightId(getInt());
		System.out.println("Enter flight Name");
		flight.setFlightName(getString());
		System.out.println("Enter flight Cost");
		flight.setTicketCost(getFloat());
		return flight;
	}

	private static Person getPersonDetails() {
		Person person = new Person();
		System.out.println("Enter person Id");
		person.setPersonId(getInt());
		System.out.println("Enter person Name");
		person.setPersonName(getString());
		System.out.println("Enter person balance");
		person.setBankBalance(getFloat());
		return person;
	}

	private static int assignFlight() {
		int result = 0;
		System.out.println("Enter personId");
		int personId = getInt();
		System.out.println("Enter flightId");
		int flightId = getInt();
		try {
			result = flightService.bookFlight(personId, flightId);
		} catch (FlighApplicationException e) {
			System.err.println(e.getMessage());
		}
		return result;
	}

	private static void displayFlight(List<Flight> flights) {
		flights.forEach(flight -> {
			System.out.println(flight.getFlightName());
		});
	}

	private static void diplayPersons(List<Person> persons) {
		persons.forEach(person -> {
			System.out.println(person.getPersonName());
		});
	}

	public static void main(String[] args) {
		int choice = 0;
		boolean endProgram = false;
		do {
			System.out.println("1. Insert flight");
			System.out.println("2. Insert Person");
			System.out.println("3. Assign flight");
			System.out.println("4. Display all flights");
			System.out.println("5. Display persons have balance > 50000");
			System.out.println("Enter your choice!");
			choice = getInt();
			switch (choice) {
			case 1:
				try {
					if (flightService.registerFlight(getFlightData()) == 1) {
						System.out.println("Flight registered!");
					} else {
						System.out.println("Flight registration failed");
					}
				} catch (FlighApplicationException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try {

					if (personService.registerPerson(getPersonDetails()) == 1) {
						System.out.println("Person registered!");
					} else {
						System.out.println("Person registration failed");
					}
				} catch (FlighApplicationException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				if (assignFlight() == 1) {
					System.out.println("Flight assigned to the person");
				} else {
					System.out.println("Flight assignment failed.");
				}
				break;
			case 4:
				try {
					displayFlight(flightService.getAllFlights());
				} catch (FlighApplicationException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				try {
					diplayPersons(personService.getFilteredPersons());
				} catch (FlighApplicationException e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				endProgram = true;
			}
		} while (!endProgram);
	}

}
