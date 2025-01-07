Feature: Purchase the product from e-commerce website

  Background:
  Given I landed on Ecommerce Page
  
  @Regression
  Scenario Outline: Positive test of submitting the order
    Given Logged in with emailId <username> and password <password>
    When I add product <productName> to cart
    And  Checkout <productName> and submit to the cart
    Then "Thankyou for the order." msg is displayed on ConfirmationPage

    Examples: 
      | username                    |     password    | productName  |
      | ankit.solanki@appfoster.com |     ankit123    | IPHONE 13 PRO|
