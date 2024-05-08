package com.learning.spring;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Initializer.class);
		PassengerDAO passengerDAO = context.getBean("passengerDAO", PassengerDAO.class);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("--------Bus Booking System-------");
			System.out.println("Press 1 for Insert");
			System.out.println("Press 2 for Update");
			System.out.println("Press 3 for Retrieve");
			System.out.println("Press 4 for Delete");
			System.out.println("Press 5 for Quit");
			System.out.println("Make your Choice");

			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter passenger name:");
				String name = scanner.next();
				System.out.println("Enter passenger date of birth (YYYY-MM-DD):");
				String dobStr = scanner.next();
				LocalDate dob = LocalDate.parse(dobStr);
				System.out.println("Enter passenger phone:");
				Long phone = scanner.nextLong();
				System.out.println("Enter passenger email:");
				String email = scanner.next();
				Passenger newPassenger = new Passenger(name, dob, phone, email);
				passengerDAO.save(newPassenger);
				System.out.println("Passenger inserted successfully.");
				break;
			case 2:
				System.out.println("Enter passenger ID to update:");
				int idToUpdate = scanner.nextInt();
				Passenger passengerToUpdate = passengerDAO.get(idToUpdate);
				if (passengerToUpdate != null) {
					System.out.println("Enter new name:");
					String newName = scanner.next();
					System.out.println("Enter new date of birth (YYYY-MM-DD):");
					String newDobStr = scanner.next();
					LocalDate newDob = LocalDate.parse(newDobStr);
					System.out.println("Enter new phone:");
					Long newPhone = scanner.nextLong();
					System.out.println("Enter new email:");
					String newEmail = scanner.next();
					passengerToUpdate.setPassenger_name(newName);
					passengerToUpdate.setPassenger_dob(newDob);
					passengerToUpdate.setPassenger_phone(newPhone);
					passengerToUpdate.setPassenger_email(newEmail);
					passengerDAO.update(passengerToUpdate);
					System.out.println("Passenger updated successfully.");
				} else {
					System.out.println("Passenger not found.");
				}
				break;

			case 3:
				List<Passenger> passengers = passengerDAO.loadAll();
			    if (passengers.isEmpty()) {
			        System.out.println("No passengers found.");
			    } else {
			        System.out.println("Passenger Details:");
			        System.out.println("-----------------------------------------------------");
			        System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s |\n", 
			                "ID", "Name", "Date of Birth", "Phone", "Email");
			        System.out.println("------------------------------------------------------");
			        for (Passenger passenger : passengers) {
			            System.out.printf("| %-10d | %-10s | %-10s | %-10s | %-10s |\n", 
			                    passenger.getPassenger_id(), 
			                    passenger.getPassenger_name(), 
			                    passenger.getPassenger_dob(), 
			                    passenger.getPassenger_phone(), 
			                    passenger.getPassenger_email());
			        }
			        System.out.println("------------------------------------------------------");
			    }
			    break;

			case 4:

				System.out.println("Enter passenger ID to delete:");
				int idToDelete = scanner.nextInt();
				Passenger passengerToDelete = passengerDAO.get(idToDelete);
				if (passengerToDelete != null) {
					passengerDAO.delete(idToDelete);
					System.out.println("Passenger deleted successfully.");
				} else {
					System.out.println("Passenger not found.");
				}
				break;

			case 5:
				System.out.println("Exiting...");
				scanner.close();
				context.registerShutdownHook();
				context.close();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please select again.");
			}
		}

	}
}