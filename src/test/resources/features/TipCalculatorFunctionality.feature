Feature: Tip Calculator Functionality

  Scenario: Test the display of error message for no inputs.
    Given I am on Tip Calculator Website Launch Browser
    When I am Clear the TIP PERCENTAGE input element
    And I am Click on the CALCULATE button
    Then The Tip Calculator page should be show the Error Message

    #Test the display of error message for invalid inputs.
  Scenario: Test the display of error message for invalid inputs.
    Given I am on Tip Calculator Website Launch Browser
    When I am Enter the TIP PERCENTAGE input element as 10f
    And I am Click on the CALCULATE button invalid inputs
    Then The Tip Calculator page should be show the Error Message invalid inputs

    #Test the tip calculation.
  Scenario: Test the tip calculation.
    Given I am on Tip Calculator Website Launch Browser
    When I am Enter the  bill amount input element as 1000
    And  I am Enter the tip percentage input element as 15
    And I am Click on the CALCULATE button tip calculation
    Then The Tip Calculator page should be show the tip amount input text and total amount input text
