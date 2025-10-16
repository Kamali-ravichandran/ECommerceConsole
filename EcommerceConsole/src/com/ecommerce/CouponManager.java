package com.ecommerce;

public class CouponManager {
	 public double applyCoupon(String code, double total) {
	        switch (code.toUpperCase()) {
	            case "SAVE10":
	                if (total >= 1000) {
	                    System.out.println("Applied 10% discount!");
	                    return total * 0.9;
	                }
	                break;
	            case "SAVE20":
	                if (total >= 3000) {
	                    System.out.println("Applied 20% discount!");
	                    return total * 0.8;
	                }
	                break;
	            default:
	                System.out.println("Invalid or ineligible coupon.");
	        }
	        return total;
	    }

}
