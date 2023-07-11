@Demo
Feature: Login to Sauce Demo

  @Login_sucessfully
  Scenario: Successful login
    Given "Carlos" on the login page
    When enter valid credentials
    Then he should be logged in successfully with message "PRODUCTS"

  @Login_invalid
  Scenario: Failed login
    Given "Juan" on the login page
    When enter invalid credentials
    Then He should see an error message "Username and password do not match any user in this service"