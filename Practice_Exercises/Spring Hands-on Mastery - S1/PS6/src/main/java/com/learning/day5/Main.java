package com.learning.day5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		ShoppingCart shoppingCart = context.getBean("shoppingCart", ShoppingCart.class);
		// Create instances of Battery and Disc
		// Add some products to the shopping cart
		Battery battery = new Battery(1001, "Rechargeable Battery", (float) 10.0, true);
		Disc disc = new Disc(1002, "DVD", (float) 20.0, 700);
		shoppingCart.addItem(battery);
		shoppingCart.addItem(disc);

		// Display the items in the shopping cart
		System.out.println("Items in the shopping cart:");
		for (Product item : shoppingCart.getItems()) {
			System.out.println(item);
		}
	}
}
