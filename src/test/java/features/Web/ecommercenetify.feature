Feature: Place order for products

  @placeEcommerceOrder
Scenario Outline: User experience for Creating editing deleting and searching of products
Given User is on Ecommerce landing page
When User clicks on add button
Then Product is added successfully
Then User edits the product
Then User edit is successful
Then User deletes a product
Then User deletion is successful
Then User searches a product and search is successful
