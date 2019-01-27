package com.cart.entity;

import java.util.Vector;

public class ShoppingCart {
	private Vector items;
	private double totalCost;

	public ShoppingCart() {
		this.items = new Vector();
		this.totalCost = 0;
	}

	public Vector getItems() {
		return items;
	}


	public double getTotalCost() {
		return Math.round((totalCost*100))/100.0;
	}
	
	public void addItem(ShoppingCartItem newItem) {
		this.items.add(newItem);
		totalCost+= newItem.cost*newItem.quantity;
	}


	
	
	
}
