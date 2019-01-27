package com.cart.entity;

import java.util.Vector;

public class ShoppingCart {
	private Vector items;
	private double totalCost;
	private double salesTax;
	private double salesTaxAmount;

	public ShoppingCart() {
		this.items = new Vector();
		this.totalCost = 0;
	}
	
	public double getSalesTaxAmount() {
		return salesTaxAmount;
	}

	public double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	public Vector getItems() {
		return items;
	}


	public double getTotalCost() {
		if(salesTax > 0) {
			salesTaxAmount = Math.round((totalCost*salesTax)/100);
			totalCost+=salesTaxAmount;
		}
		return Math.round((totalCost*100))/100.0;
	}
	
	public void addItem(ShoppingCartItem newItem) {
		int currentIndex = items.indexOf(newItem);
		if(currentIndex == -1) {
			this.items.add(newItem);
		} else {
			ShoppingCartItem shoppingCartItem = (ShoppingCartItem) items.elementAt(currentIndex);
			shoppingCartItem.add(newItem);
		}
		totalCost+= newItem.cost*newItem.quantity;
		if(salesTax > 0) {
			salesTaxAmount = Math.round((totalCost*salesTax)/100);
		}
	}
}
