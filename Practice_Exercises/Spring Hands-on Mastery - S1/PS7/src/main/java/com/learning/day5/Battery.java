package com.learning.day5;

import org.springframework.stereotype.Component;

@Component
public class Battery extends Product {
	private boolean rechargeable;
	

	public Battery(int product_id, String product_name, float price, boolean rechargeable) {
		super(product_id, product_name, price);
		this.rechargeable = rechargeable;

	}

	public boolean isRechargeable() {
		return rechargeable;
	}

	public void setRechargeable(boolean rechargeable) {
		this.rechargeable = rechargeable;
	}

	 @Override
	    public String toString() {
	        return "Battery{id=" + getProduct_id() + ", name='" + getProduct_name() + "', price=" + getPrice() + ", rechargeable=" + rechargeable + "}";
	    }

}
