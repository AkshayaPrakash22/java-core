package com.learning.day5;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		ShoppingCart shoppingCart = context.getBean("shoppingCart", ShoppingCart.class);
		Cashier cashier = context.getBean("cashier", Cashier.class);

		// Add some products to the shopping cart
		Battery battery = context.getBean("battery", Battery.class);
		Disc disc = context.getBean("disc", Disc.class);
		shoppingCart.addItem(battery);
		shoppingCart.addItem(disc);

		// Perform checkout using Cashier
		try {
			cashier.checkout(shoppingCart);
			System.out.println("Checkout completed successfully.");
		} catch (IOException e) {
			System.out.println("Error during checkout: " + e.getMessage());
		}

	}

}
