package com.day3.learning;

import java.util.HashMap;
import java.util.Map;

public class D03P01 {

	public static void main(String[] args) {
        // Create a HashMap to store phone book entries
        Map<String, String> phoneBook = new HashMap<>();

        // Predefined information
        phoneBook.put("Amal", "9234567890");
        phoneBook.put("Manvitha", "9876543210");
        phoneBook.put("Joseph", "6567890123");
        phoneBook.put("Smith", "7890123456");
        phoneBook.put("Kathe", "9210987654");

        System.out.println("Phone Book Details:");
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + " "+ entry.getValue());
        }
    }
}
