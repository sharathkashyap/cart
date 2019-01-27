package com.cart.entity;

public class ShoppingCartItem {
	protected String productName;
	protected int quantity;
	protected double cost;
	
	public ShoppingCartItem(String productName, int quantity, double cost) {
		this.productName = productName;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	public void add(ShoppingCartItem item) {
		this.quantity+=item.quantity;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if(!(obj instanceof ShoppingCartItem)) {
			return false;
		}
		ShoppingCartItem shoppingCartItem = (ShoppingCartItem) obj;
		return this.productName.equals(shoppingCartItem.productName) && 
				this.cost == shoppingCartItem.cost;
	}
	
	
	
}
