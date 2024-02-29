Feature: Login

  In order to do search products
  As a valid Ultimate QA user
  I want to login successfully

  Scenario: Login Successfully

    Given I am in the login page of the Ultimate QA website
    When I enter valid credentials
    Then I should be taken to Products page