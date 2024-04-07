package com.day3.learning;

import java.util.HashSet;
import java.util.Iterator;


public class D03P03 {
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

		String searchProductId = "P003";
		String searchProductName = "Maruti Dezire";
		boolean found = false;
		Iterator<Product> iterator = hs.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();
			if (product.getProductId() == searchProductId
					&& product.getProductName().equalsIgnoreCase(searchProductName)) {
				found = true;
				System.out.println("Product Found");
				break;
			}
		}
		if (found == false) {
			System.out.println("Product Not Found");
		}

	}
}
