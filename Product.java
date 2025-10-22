package com.ecommerce;

public class Product {
	 private int id;
	    private String name;
	    private String category;
	    private double price;
	    private int stock;

	    public Product(int id, String name, String category, double price, int stock) {
	        this.id = id;
	        this.name = name;
	        this.category = category;
	        this.price = price;
	        this.stock = stock;
	    }

	    public int getId() { return id; }
	    public String getName() { return name; }
	    public String getCategory() { return category; }
	    public double getPrice() { return price; }
	    public int getStock() { return stock; }

	    public void reduceStock(int qty) { this.stock -= qty; }
	    public void increaseStock(int qty) { this.stock += qty; }

	    @Override
	    public String toString() {
	        return String.format("[%d] %s (%s) - ₹%.2f | Stock: %d",
	                id, name, category, price, stock);
	    }
}
