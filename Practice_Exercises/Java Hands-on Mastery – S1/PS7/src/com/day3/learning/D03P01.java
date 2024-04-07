package com.day3.learning;

import java.util.ArrayList;
import java.util.Scanner;

public class D03P01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> studentNames = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);

		// Adding student names to the ArrayList
		System.out.println("Enter student names (type 'done' to finish):");
		String name = scanner.nextLine();
		while (!name.equalsIgnoreCase("done")) {
			studentNames.add(name);
			name = scanner.nextLine();
		}

		// Getting name to search
		System.out.println("Enter the name you want to search:");
		String searchName = scanner.nextLine();

		// Searching for the name in the list
		if (studentNames.contains(searchName)) {
			System.out.println("Found");
		} else {
			System.out.println("Not Found");
		}
	}
}
