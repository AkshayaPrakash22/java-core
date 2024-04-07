package com.day3.learning;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class D03P08 {
	public static void main(String[] args) {
		TreeMap<Double, String> carMap = new TreeMap<>();
		carMap.put(80050.0, "Buggatti");
		carMap.put(300500.0, "Swift");
		carMap.put(600000.0, "Audi");
		carMap.put(9000000.0, "Benz");
		
		Entry<Double, String> greatestPriceEntry = carMap.pollLastEntry();
		
		System.out.println("After Removing the greatest key");
        for (Entry<Double, String> entry : carMap.entrySet()) {
            System.out.println(entry.getValue() + "  " + entry.getKey());
            
        }
        
        double keyToReplace = 80050.0;
        String newValue = "Reva"; // New value to replace with
        carMap.replace(keyToReplace, newValue);

        // Print the updated car details
        System.out.println("\nUpdated Car Details:");
        for (Map.Entry<Double, String> entry : carMap.entrySet()) {
            System.out.println(entry.getValue() + " "  + entry.getKey());
        }
        
        
	}

}
