package com.day3.learning;

import java.util.Map.Entry;
import java.util.TreeMap;

public class D03P07 {

	public static void main(String[] args) {


		TreeMap<Double, String> carMap = new TreeMap<>();
		carMap.put(80050.0, "Buggatti");
		carMap.put(300500.0, "Swift");
		carMap.put(600000.0, "Audi");
		carMap.put(9000000.0, "Benz");
		
		Entry<Double, String> leastPriceEntry = carMap.firstEntry();
		Entry<Double, String> greatestPriceEntry = carMap.lastEntry();

        System.out.println("Car with least price: " + leastPriceEntry.getKey() + ", Name: " + leastPriceEntry.getValue());
        System.out.println("Car with greatest price: " + greatestPriceEntry.getKey() + ", Name: " + greatestPriceEntry.getValue());

	}

}
