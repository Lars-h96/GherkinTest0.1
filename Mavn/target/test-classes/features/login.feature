Feature: Login

  #Basic example
  Scenario: User successfully logs in
    Given user is on the login page
    When the user fills in the username and password
    And proceeds login in
    Then user is successfully logged in