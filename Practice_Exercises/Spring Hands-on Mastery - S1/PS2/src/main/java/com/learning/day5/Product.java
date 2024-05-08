package com.learning.day5;

public abstract class Product {
	int product_id;
	String product_name;
	float price;

	public Product(int product_id, String product_name, float price) {
		
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}
	
}
