package com.learning.day5;

import org.springframework.stereotype.Component;

@Component
public abstract class Product {

	int product_id;
	String product_name;
	float price;

	public Product(int product_id, String product_name, float price) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + "]";
	}

}
