package com.ecommerce;

import java.util.ArrayList;
import java.util.List;
public class User {
	  private int userId;
	    private String name;
	    private String email;
	    private List<String> purchaseHistory = new ArrayList<>();

	    public User(int id, String name, String email) {
	        this.userId = id;
	        this.name = name;
	        this.email = email;
	    }

	    public void addPurchase(String details) {
	        purchaseHistory.add(details);
	    }

	    public void viewHistory() {
	        if (purchaseHistory.isEmpty()) {
	            System.out.println("No past purchases.");
	        } else {
	            System.out.println("Purchase History:");
	            purchaseHistory.forEach(System.out::println);
	        }
	    }

}
