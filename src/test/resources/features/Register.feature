Feature: Register Functionality
  @SmokeTest @RegressionTest
  Scenario: Register with valid details

    Given User opens Demo Web Shop Register page
    When User selects Male gender
    And User enter validuserdetails
    And User clicks on Register button
    And User should register successfully
    Then User should able to login
    
    @RegressionTest
    Scenario: Register with invalid details
    
    Given User opens Demo Web Shop Register page
    When User clicks on Register button
    Then Validation should fire for mandatory field
    
    
    


  