package com.learning.day5;

import org.springframework.stereotype.Component;

@Component
public class Disc extends Product {
    private int capacity;
    


	public Disc(int product_id, String product_name, float price, int capacity) {
		super(product_id, product_name, price);
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
    public String toString() {
        return "Disc{id=" + getProduct_id() + ", name='" + getProduct_name() + "', price=" + getPrice() + ", capacity=" + capacity + "}";
    }
    
	
    

}