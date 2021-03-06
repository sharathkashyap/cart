package com.cart.entity;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestCart {
	ShoppingCart shoppingCart;
	ShoppingCartItem shoppingCartItem;
	private HashMap<String, ShoppingCartItem> shoppingCartItems;
	
	@Given("^An empty shopping cart$")
	public void an_empty_shopping_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		shoppingCart = new ShoppingCart();
		shoppingCartItems = new HashMap<String, ShoppingCartItem>();
	}

	@Given("^And a product, \"(.*?)\" with a unit price of \"(.*?)\"$")
	public void and_a_product_with_a_unit_price_of(String productName, String cost) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		shoppingCartItem = new ShoppingCartItem(productName, 1, Double.parseDouble(cost));
		shoppingCartItems.put(productName, shoppingCartItem);
	}
	
	@Given("^And a sales tax rate of \"(.*?)\"%$")
	public void and_a_sales_tax_rate_of(String salesTax) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		shoppingCart.setSalesTax(Double.parseDouble(salesTax));
	}

	@When("^The user adds (\\d+) Dove Soaps to the shopping cart$")
	public void the_user_adds_Dove_Soaps_to_the_shopping_cart(int quantity) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ShoppingCartItem temp = shoppingCartItems.get("Dove Soap");
		temp.quantity = quantity;
		shoppingCart.addItem(temp);
	}
	
	@When("^then adds another (\\d+) \"(.*?)\"s to the shopping cart$")
	public void then_adds_another_s_to_the_shopping_cart(int additionalQuantity, String productName) throws Throwable {
		ShoppingCartItem temp = shoppingCartItems.get(productName);
		ShoppingCartItem additionalItem = new ShoppingCartItem(productName, additionalQuantity, temp.cost);
	    shoppingCart.addItem(additionalItem);
	}

	@Then("^The shopping cart should contain (\\d+) \"(.*?)\"s each with a unit price of \"(.*?)\",$")
	public void the_shopping_cart_should_contain_s_each_with_a_unit_price_of(int quantity, String productName, String cost) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ShoppingCartItem newItem = new ShoppingCartItem(productName, quantity,Double.parseDouble(cost));
		int currentIndex = shoppingCart.getItems().indexOf(newItem);
		ShoppingCartItem item = (ShoppingCartItem) shoppingCart.getItems().elementAt(currentIndex);
		assertTrue(item.productName.equals(productName));
		assertTrue(item.quantity == quantity);
	    assertTrue(item.cost == Double.parseDouble(cost));
	}

	@Then("^the shopping cart total price should equal \"(.*?)\"$")
	public void the_shopping_cart_total_price_should_equal(String totalCost) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(shoppingCart.getTotalCost() == Double.parseDouble(totalCost));
	}
	
	@Then("^the total sales tax amount for the shopping cart should equal \"(.*?)\"$")
	public void the_total_sales_tax_amount_for_the_shopping_cart_should_equal(String salesTaxAmount) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertTrue(shoppingCart.getSalesTaxAmount() == Double.parseDouble(salesTaxAmount));
	}
}
