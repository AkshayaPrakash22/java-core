package com.day3.learning;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class D03P04 {

	public static void main(String[] args) {
		HashSet<Product> hs = new HashSet<>();

		// Predefined product information
		Product product1 = new Product("P001", "Maruti 800");
		Product product2 = new Product("P002", "Maruti Zen");
		Product product3 = new Product("P003", "Maruti Dezire");
		Product product4 = new Product("P004", "Maruti Alto");

		// Storing products in HashSet
		hs.add(product1);
		hs.add(product2);
		hs.add(product3);
		hs.add(product4);

		Scanner s = new Scanner(System.in);
		System.out.println("Enter product id to remove");
		String removeProductId = s.nextLine();
        Iterator<Product> iterator = hs.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductId().equals(removeProductId)) {
                iterator.remove();
                break; 
            }
        }

        System.out.println("After Removed");
        for (Product product : hs) {
            System.out.println(product.getProductId() + " " + product.getProductName());
        }
    }
}
