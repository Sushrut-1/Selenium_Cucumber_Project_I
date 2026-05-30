Feature: Login Functionality

  Background:
    
    Given User opens Demo Web Shop application

  @SmokeTest
  Scenario: Login with valid credentials
    When User enters email as "ssparab@gmail.com"
    And User enters password as "test@123"
    And User clicks on Login button
    Then User should login successfully

  @RegressionTest
  Scenario: Login with invalid password
    When User enters email as "sqp@gmail.com"
    And User enters password as "wrong123"
    And User clicks on Login button
    Then User should see login error message

  @RegressionTest
  Scenario: Login with empty credentials
    When User enters email as ""
    And User enters password as ""
    And User clicks on Login button
    Then User should see validation message