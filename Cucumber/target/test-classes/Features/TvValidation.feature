#Author: sakthi.email@your.domain.com
@Tv
Feature: Tv Validation

  Background: 
    Given User launches flipkart application for Tv Purchase
    And User handles login for Tv purchase

  Scenario: 
    When User search Tv "LG"
    And User select the Tv and click add to cart
    And User doing the Tv payment
    Then User receive the Tv payment confirmation message


    
  Scenario Outline: 
    When User search Tv "<TV>"
    And User select the Tv and click add to cart
    And User doing the Tv payment
    Then User receive the Tv payment confirmation message

    Examples: 
      | TV      |
      | SAMSUNG |
      | SONY    |
      | LG      |
