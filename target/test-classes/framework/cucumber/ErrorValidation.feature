Feature: Error Validation

  @errorValidation
  Scenario Outline: Negative test scenerio
    Given I landed on Ecommerce Page
    When Logged in with emailId <username> and password <password>
    Then "Incorrect email or password." msg is displayed

     Examples: 
      | username                    |     password    | productName  |
      | ankit.solanki@appfoster.com |     ankit13     | IPHONE 13 PRO|