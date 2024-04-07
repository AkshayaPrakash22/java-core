package com.day3.learning;

import java.util.Map.Entry;
import java.util.TreeMap;



public class D03P06 {
	public static void main(String[] args) {


		TreeMap<Double, String> carMap = new TreeMap<>();
		carMap.put(80050.0, "Buggatti");
		carMap.put(300500.0, "Swift");
		carMap.put(600100.0, "Audi");
		carMap.put(9000000.0, "Benz");
		
		for(Entry<Double, String> map:carMap.descendingMap().entrySet()) {
			System.out.println(map.getValue()+" "+map.getKey());
		}
		
	}
}
