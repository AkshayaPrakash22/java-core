package com.learning.day5;

public class DiscountService {
	public void calculateTotalWithDiscount(ShoppingCart cart) {
		double total = 0;
		for (Product product : cart.getProducts()) {
			total += applyDiscount(product);
		}
		
		System.out.println("Total after discount: $" + total);
	}

	private double applyDiscount(Product product) {
		double price = product.getPrice();
		double discount = product.getDiscount();
		double discountedPrice = price - (price * discount);
		System.out.println("Discount:"+product.product_name +" "+discountedPrice);
		return discountedPrice;
	}
}
