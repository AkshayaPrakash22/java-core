package com.learning.spring;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}
