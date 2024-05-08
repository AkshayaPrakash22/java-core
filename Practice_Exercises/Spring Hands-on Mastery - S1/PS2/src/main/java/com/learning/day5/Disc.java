package com.learning.day5;

public class Disc extends Product {
	private int capacity;

	public Disc(int product_id, String product_name, float price, int capacity) {
		super(product_id, product_name, price);
		this.capacity = capacity;
	}

}
