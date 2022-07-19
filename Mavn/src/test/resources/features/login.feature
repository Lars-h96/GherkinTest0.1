Feature: Login

  #Basic example
  Scenario: User successfully logs in
    Given user is on the login page
    When the user fills in the username and password
    And proceeds login in
    Then user is successfully logged in

    #Example for using variable data
  Scenario Outline: Multiple users login
    Given user is on the login page
    When the user fills in the <username> and <password>
    And proceeds login in
    Then user is successfully logged in

    Examples:
    |username|password|
    |standard_user|secret_sauce|
    |problem_user |secret_sauce|