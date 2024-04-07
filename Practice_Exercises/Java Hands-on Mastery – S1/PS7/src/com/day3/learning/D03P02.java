package com.day3.learning;

import java.util.HashSet;

class Product {
    private String productId;
    private String productName;

    public Product(String productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}

public class D03P02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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

       
        System.out.println("List of all products in HashSet:");
        for (Product product : hs) {
            System.out.println(product.getProductId() + " "+product.getProductName());
        }
    }

	}

