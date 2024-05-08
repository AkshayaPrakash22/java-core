package com.learning.day5;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create the AnnotationConfigApplicationContext
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // Register the configuration class
        context.register(AppConfig.class);

        // Refresh the context to load and initialize the beans
        context.refresh();

        // Retrieve the ShoppingCart bean from the context
        ShoppingCart shoppingCart = context.getBean(ShoppingCart.class);

        // Add some products to the shopping cart
        Battery battery = new Battery(1001, "Rechargeable Battery", 10.0f, true);
        Disc disc = new Disc(1002, "DVD", 20.0f, 700);
        shoppingCart.addItem(battery);
        shoppingCart.addItem(disc);

        // Display the items in the shopping cart
        System.out.println("Items in the shopping cart:");
        for (Product item : shoppingCart.getItems()) {
            System.out.println(item);
        }

        // Close the context
        context.close();
    }
		

		

	}


