package com.learning.spring;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
        // Load Spring configuration
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("Passenger-module.xml");
        PassengerDAO passengerDao = context.getBean("passengerDao", PassengerDAO.class);
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("------------Bus Booking System----------");
            System.out.println("Press 1 for Insert");
            System.out.println("Press 2 for Update");
            System.out.println("Press 3 for Retrieve");
            System.out.println("Press 4 for Delete");
            System.out.println("Press 5 to Quit");
            System.out.println("\n\nMake your Choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insert(passengerDao, scanner);
                    break;
                case 2:
                    update(passengerDao, scanner);
                    break;
                case 3:
                    getAllPassengers(passengerDao);
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
        scanner.close();
        context.close(); // Close Spring context to release resources
    }

    private static void insert(PassengerDAO passengerDao, Scanner scanner) {
    	Passenger passenger = new Passenger();
        System.out.println("Enter Passenger ID:");
        passenger.setPassenger_id(scanner.nextInt());
        System.out.println("Enter Passenger Name:");
        passenger.setPassenger_name(scanner.next());
        System.out.println("Enter Passenger DOB (YYYY-MM-DD):");
        String dobString = scanner.next();
        LocalDate dob = LocalDate.parse(dobString);
        passenger.setPassenger_dob(dob);
        System.out.println("Enter Passenger Phone:");
        passenger.setPassenger_phone(scanner.nextLong());
        System.out.println("Enter Passenger Email:");
        passenger.setPassenger_email(scanner.next());

        passengerDao.insert(passenger);
        System.out.println("Passenger created successfully.");
    }

    private static void getAllPassengers(PassengerDAO passengerDao) {
        List<Passenger> passengers = passengerDao.getAllPassengers();
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    private static void update(PassengerDAO passengerDao, Scanner scanner) {
        System.out.println("Enter Passenger ID:");
        int id = scanner.nextInt();
        Passenger passenger = passengerDao.getPassengerById(id);
        if (passenger != null) {
            System.out.println("Enter new name:");
            String newName = scanner.next();
            System.out.println("Enter new DOB (YYYY-MM-DD):");
            String newDobString = scanner.next();
            LocalDate newDob = LocalDate.parse(newDobString); // Parse input String to LocalDate
            System.out.println("Enter new phone:");
            long newPhone = scanner.nextLong();
            System.out.println("Enter new email:");
            String newEmail = scanner.next();

            // Set the new values to the Passenger object
            passenger.setPassenger_name(newName);
            passenger.setPassenger_dob(newDob); // Set the parsed LocalDate
            passenger.setPassenger_phone(newPhone);
            passenger.setPassenger_email(newEmail);

            // Update the passenger in the database
            passengerDao.update(passenger);
            System.out.println("Passenger updated successfully.");
        } else {
            System.out.println("Passenger not found.");
        }
    }
    
    private static void deletePassenger(PassengerDAO passengerDao, Scanner scanner) {
        System.out.println("Enter Passenger ID:");
        int id = scanner.nextInt();
        passengerDao.delete(id);
        System.out.println("Passenger deleted successfully.");
    }
}