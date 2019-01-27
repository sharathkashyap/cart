Feature: Cart

	Scenario: Add products to the shopping cart
    Given An empty shopping cart
    Given And a product, "Dove Soap" with a unit price of "39.99"
    When The user adds 5 Dove Soaps to the shopping cart
    Then The shopping cart should contain 5 "Dove Soap"s each with a unit price of "39.99", 
    	And the shopping cart total price should equal "199.95"