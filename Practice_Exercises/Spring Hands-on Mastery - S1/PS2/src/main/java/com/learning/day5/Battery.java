package com.learning.day5;

public class Battery extends Product {

	private boolean rechargeable;

	public Battery(int product_id, String product_name, float price, boolean rechargeable) {
		super(product_id, product_name, price);
		this.rechargeable = rechargeable;
	}

	
	
}
