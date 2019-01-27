Feature: Cart

	Scenario: Add products to the shopping cart
    Given An empty shopping cart
    Given And a product, "Dove Soap" with a unit price of "39.99"
    When The user adds 5 Dove Soaps to the shopping cart
    Then The shopping cart should contain 5 "Dove Soap"s each with a unit price of "39.99", 
    	And the shopping cart total price should equal "199.95"
    	
    Scenario: Add additional products of the same type to the shopping cart
    Given An empty shopping cart
    Given And a product, "Dove Soap" with a unit price of "39.99"
    When The user adds 5 Dove Soaps to the shopping cart
    	And then adds another 3 "Dove Soap"s to the shopping cart
    Then The shopping cart should contain 8 "Dove Soap"s each with a unit price of "39.99", 
    	And the shopping cart total price should equal "319.92"
    	
    Scenario: Calculate the tax rate of the shopping cart with multiple items
    Given An empty shopping cart
    Given And a product, "Dove Soap" with a unit price of "39.99"
    Given And a product, "Axe Deo" with a unit price of "99.99"
    Given And a sales tax rate of "12.5"%
    When The user adds 2 Dove Soaps to the shopping cart
    	And then adds another 2 "Axe Deo"s to the shopping cart
    Then The shopping cart should contain 2 "Dove Soap"s each with a unit price of "39.99",
    	And The shopping cart should contain 2 "Axe Deo"s each with a unit price of "99.99",
    	And the total sales tax amount for the shopping cart should equal "35.00" 
    	And the shopping cart total price should equal "314.96"