Feature: Buy different currencies

  Scenario: Convert USD from EUR
    Given I want to buy 170 USD using EUR
    When the conversion is done
    Then should it cost me 147 EUR
