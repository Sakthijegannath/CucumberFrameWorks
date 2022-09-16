#Author: sakthi.email@your.domain.com
@Mobile
Feature: Mobile validation

  Background: 
    Given User launches flipkart application
    And User handles login

  Scenario: Mobile Validation
    When User search mobile "realme"
    And User select the mobile and click add to cart
    And User doing the payment
    Then User receive the confirmation message

  Scenario: Mobile Validation by using list
    When User search mobile by using OneD list
      | realme |  | iPhone |  | redmi |
    And User select the mobile and click add to cart
    And User doing the payment
    Then User receive the confirmation message

  Scenario: Mobile Validation by using map
    When User search mobile by using OneD map
      | A | realme |
      | B | iPhone |
      | C | redmi  |
    And User select the mobile and click add to cart
    And User doing the payment
    Then User receive the confirmation message

  Scenario Outline: 
    When User search mobile "<Phone>"
    And User select the mobile and click add to cart
    And User doing the payment
    Then User receive the confirmation message

    Examples: 
      | Phone  |
      | realme |
      | iPhone |
      | REDMI  |
