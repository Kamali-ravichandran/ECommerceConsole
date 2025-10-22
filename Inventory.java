package com.ecommerce;


import java.util.*;
import java.util.stream.Collectors;
public class Inventory {
	 private List<Product> products = new ArrayList<>();

	    public void loadSampleProducts() {
	        products.add(new Product(1, "iPhone 15", "Electronics", 79999, 5));
	        products.add(new Product(2, "T-Shirt", "Fashion", 799, 20));
	        products.add(new Product(3, "Shoes", "Fashion", 1999, 15));
	        products.add(new Product(4, "Book - Java Basics", "Books", 499, 10));
	        products.add(new Product(5, "Headphones", "Electronics", 1499, 12));
	    }

	    public List<Product> getProducts() { return products; }

	    public Product getById(int id) {
	        return products.stream()
	                .filter(p -> p.getId() == id)
	                .findFirst()
	                .orElse(null);
	    }

	    public void showAll() {
	        products.forEach(System.out::println);
	    }

	    public void searchByCategory(String category) {
	        List<Product> filtered = products.stream()
	                .filter(p -> p.getCategory().equalsIgnoreCase(category))
	                .collect(Collectors.toList());
	        if (filtered.isEmpty()) {
	            System.out.println("No products found in category: " + category);
	        } else {
	            filtered.forEach(System.out::println);
	        }
	    }

	    public void sortByPrice() {
	        products.stream()
	                .sorted(Comparator.comparing(Product::getPrice))
	                .forEach(System.out::println);
	    }

}
