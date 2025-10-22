package com.ecommerce;
import java.util.*;

public class ECommerceApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner sc = new Scanner(System.in);
	        Inventory inventory = new Inventory();
	        inventory.loadSampleProducts();
	        Cart cart = new Cart();
	        CouponManager coupons = new CouponManager();
	        User user = new User(1, "Anna", "anna@example.com");

	        System.out.println("===== Welcome to Console E-Commerce System =====");

	        boolean running = true;
	        while (running) {
	            System.out.println("\n1. View All Products");
	            System.out.println("2. Search by Category");
	            System.out.println("3. Sort Products by Price");
	            System.out.println("4. Add Product to Cart");
	            System.out.println("5. View Cart");
	            System.out.println("6. Apply Coupon & Checkout");
	            System.out.println("7. View Purchase History");
	            System.out.println("8. Exit");
	            System.out.print("Enter choice: ");
	            int choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                    inventory.showAll();
	                    break;
	                case 2:
	                    System.out.print("Enter category: ");
	                    String cat = sc.nextLine();
	                    inventory.searchByCategory(cat);
	                    break;
	                case 3:
	                    inventory.sortByPrice();
	                    break;
	                case 4:
	                    System.out.print("Enter Product ID to add: ");
	                    int pid = sc.nextInt();
	                    System.out.print("Enter quantity: ");
	                    int qty = sc.nextInt();
	                    Product prod = inventory.getById(pid);
	                    if (prod != null)
	                        cart.addProduct(prod, qty);
	                    else
	                        System.out.println("Invalid Product ID!");
	                    break;
	                case 5:
	                    cart.viewCart();
	                    break;
	                case 6:
	                    if (cart.isEmpty()) {
	                        System.out.println("Your cart is empty!");
	                        break;
	                    }
	                    cart.viewCart();
	                    System.out.print("Enter coupon code (or press Enter to skip): ");
	                    sc.nextLine(); // consume newline
	                    String code = sc.nextLine();
	                    double total = cart.calculateTotal();
	                    double discounted = coupons.applyCoupon(code, total);
	                    System.out.println("Final amount: ₹" + discounted);
	                    System.out.print("Confirm checkout? (y/n): ");
	                    String confirm = sc.nextLine();
	                    if (confirm.equalsIgnoreCase("y")) {
	                        System.out.println("Payment successful! ✅");
	                        user.addPurchase(cart.summary() + " | Total: ₹" + discounted);
	                        cart.clearCart();
	                    }
	                    break;
	                case 7:
	                    user.viewHistory();
	                    break;
	                case 8:
	                    running = false;
	                    System.out.println("Thank you for shopping with us!");
	                    break;
	                default:
	                    System.out.println("Invalid choice!");
	            }
	        }
	        sc.close();
	}

}
