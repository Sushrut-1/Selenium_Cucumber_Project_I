Feature: Register Functionality

  Scenario: Register with valid details

    Given User opens Demo Web Shop Register page
    When User selects Male gender
    And User enter validuserdetails
    And User clicks on Register button
    Then User should register successfully


  