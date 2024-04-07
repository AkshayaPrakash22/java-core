package com.day3.learning;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D03P02 {

	private static Map<String, String> phoneBook = new HashMap<>();
	

    private static String searchPhoneNumber(String name) {
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                return entry.getValue();
            }
        }
        return null;
    }

	public static void main(String[] args) {

		// Predefined information
		phoneBook.put("Amal", "9234567890");
		phoneBook.put("Manvitha", "9876543210");
		phoneBook.put("Joseph", "6567890123");
		phoneBook.put("Smith", "7890123456");
		phoneBook.put("Kathe", "9210987654");

		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		String phoneNumber = searchPhoneNumber(name);
		if (phoneNumber != null) {
			System.out.println(phoneNumber);
		} else {
			System.out.println("No phone number found");
		}
	}

}
