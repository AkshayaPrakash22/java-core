package com.learning.spring;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
		PassengerDAO passengerDao = context.getBean("passengerDao", PassengerDAO.class);
		Scanner scanner = new Scanner(System.in);
		boolean exit = false;

		try {
			while (!exit) {
				System.out.println("------------Passenger Management System----------");
				System.out.println("Press 1 to Insert a Passenger");
				System.out.println("Press 2 to Update a Passenger");
				System.out.println("Press 3 to Retrieve all Passengers");
				System.out.println("Press 4 to Delete a Passenger");
				System.out.println("Press 5 to Quit");

				System.out.println("\nMake your choice:");
				int choice = scanner.nextInt();

				switch (choice) {
				case 1:
					insertPassenger(passengerDao, scanner);
					break;
				case 2:
					updatePassenger(passengerDao, scanner);
					break;
				case 3:
					retrieveAllPassengers(passengerDao);
					break;
				case 4:
					deletePassenger(passengerDao, scanner);
					break;
				case 5:
					exit = true;
					break;
				default:
					System.out.println("Invalid choice. Please choose again.");
				}

				if (!exit) {
					System.out.println("Do you want to continue? (y/n)");
					char continueChoice = scanner.next().charAt(0);
					if (continueChoice == 'n' || continueChoice == 'N') {
						exit = true;
					}
				}
			}
		} finally {
			scanner.close(); // Close scanner to prevent resource leak
			context.close(); // Close Spring context to release resources
		}
	}

	private static void insertPassenger(PassengerDAO passengerDao, Scanner scanner) {
		System.out.println("Enter Passenger Name:");
		String name = scanner.next();
		System.out.println("Enter Passenger DOB (YYYY-MM-DD):");
		LocalDate dob = LocalDate.parse(scanner.next());
		System.out.println("Enter Passenger Phone:");
		Long phone = scanner.nextLong();
		System.out.println("Enter Passenger Email:");
		String email = scanner.next();

		Passenger passenger = new Passenger(name, dob, phone, email);
		passengerDao.insert(passenger);
		System.out.println("Passenger inserted successfully.");
	}

	private static void updatePassenger(PassengerDAO passengerDao, Scanner scanner) {
		System.out.println("Enter Passenger ID to update:");
		int id = scanner.nextInt();
		Passenger passenger = passengerDao.getPassengerById(id);
		if (passenger != null) {
			System.out.println("Enter new name:");
			String newName = scanner.next();
			System.out.println("Enter new DOB (YYYY-MM-DD):");
			LocalDate newDob = LocalDate.parse(scanner.next());
			System.out.println("Enter new phone:");
			Long newPhone = scanner.nextLong();
			System.out.println("Enter new email:");
			String newEmail = scanner.next();

			passenger.setPassenger_name(newName);
			passenger.setPassenger_dob(newDob);
			passenger.setPassenger_phone(newPhone);
			passenger.setPassenger_email(newEmail);

			passengerDao.update(passenger);
			System.out.println("Passenger updated successfully.");
		} else {
			System.out.println("Passenger not found.");
		}
	}

	private static void retrieveAllPassengers(PassengerDAO passengerDao) {
		System.out.println("All Passengers:");
		List<Passenger> passengers = passengerDao.getAllPassengers();
		if (passengers.isEmpty()) {
			System.out.println("No passengers found.");
		} else {
			for (Passenger passenger : passengers) {
				System.out.println(passenger);
			}
		}
	}

	private static void deletePassenger(PassengerDAO passengerDao, Scanner scanner) {
		System.out.println("Enter Passenger ID to delete:");
		int id = scanner.nextInt();
		int rowsAffected = passengerDao.delete(id);
		if (rowsAffected > 0) {
			System.out.println("Passenger deleted successfully.");
		} else {
			System.out.println("Passenger not found.");
		}
	}
}
