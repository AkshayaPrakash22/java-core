package com.learning.day5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");

		// Test the shopping cart
		ShoppingCart cart = context.getBean("shoppingCart", ShoppingCart.class);
		DiscountService discountService = context.getBean("discountService", DiscountService.class);

		// Add products to the cart
		Product battery = context.getBean("battery", Battery.class);
		Product disc = context.getBean("disc", Disc.class);
		cart.addProduct(battery);
		cart.addProduct(disc);

		// Apply discounts and calculate total
		discountService.calculateTotalWithDiscount(cart);

	}

}
