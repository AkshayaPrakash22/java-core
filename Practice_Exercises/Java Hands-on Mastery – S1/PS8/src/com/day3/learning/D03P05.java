package com.day3.learning;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

class Car implements Comparable<Car> {
	private String name;
	private double price;

	public Car(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	@Override
	public int compareTo(Car other) {
		return Double.compare(this.price, other.price);
	}
}

public class D03P05 {
	public static void main(String[] args) {

		TreeMap<Double, String> carMap = new TreeMap<>();
		carMap.put(80050.0, "Buggatti");
		carMap.put(300500.0, "Swift");
		carMap.put(600100.0, "Audi");
		carMap.put(9000000.0, "Benz");
	
		for (Map.Entry<Double, String> entry : carMap.entrySet()) {
			System.out.println(entry.getValue() + "  " + entry.getKey());
		}

	}

}
