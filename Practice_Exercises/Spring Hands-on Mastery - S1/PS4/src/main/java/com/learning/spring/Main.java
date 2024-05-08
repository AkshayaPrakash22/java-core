package com.learning.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		// Customer 1 adds products to the shopping cart
		ShoppingCart cart1 = context.getBean("shoppingCart", ShoppingCart.class);
		Battery battery1 = context.getBean("battery", Battery.class);
		Disc disc1 = context.getBean("disc", Disc.class);
		cart1.addItem(battery1);
		cart1.addItem(disc1);

		// Customer 2 adds products to the shopping cart
		ShoppingCart cart2 = context.getBean("shoppingCart", ShoppingCart.class);
		Disc disc2 = context.getBean("disc", Disc.class);
		cart2.addItem(disc2);

		// Print the contents of both shopping carts
		System.out.println("Customer 1 Shopping Cart:");
		for (Product item : cart1.getItems()) {
			System.out.println(item.getProduct_name());
		}

		System.out.println("\nCustomer 2 Shopping Cart:");
		for (Product item : cart2.getItems()) {
			System.out.println(item.getProduct_name());
		}

	}

}
