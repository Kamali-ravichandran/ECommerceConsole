package com.ecommerce;

import java.util.*;
import java.util.stream.Collectors;
public class Cart {
	private Map<Integer, CartItem> items = new HashMap<>();

    public void addProduct(Product p, int qty) {
        if (p.getStock() < qty) {
            System.out.println("Not enough stock for " + p.getName());
            return;
        }
        items.merge(p.getId(), new CartItem(p, qty),
                (existing, newItem) -> {
                    existing.setQuantity(existing.getQuantity() + qty);
                    return existing;
                });
        p.reduceStock(qty);
        System.out.println(qty + " x " + p.getName() + " added to cart.");
    }

    public void removeProduct(int productId) {
        CartItem removed = items.remove(productId);
        if (removed != null) {
            removed.getProduct().increaseStock(removed.getQuantity());
            System.out.println(removed.getProduct().getName() + " removed from cart.");
        } else {
            System.out.println("Product not found in cart!");
        }
    }

    public void viewCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        items.values().forEach(System.out::println);
        System.out.println("Total: ₹" + calculateTotal());
    }

    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clearCart() {
        items.clear();
    }

    public String summary() {
        return items.values().stream()
                .map(ci -> ci.getProduct().getName() + " x " + ci.getQuantity())
                .collect(Collectors.joining(", "));
    }

}
