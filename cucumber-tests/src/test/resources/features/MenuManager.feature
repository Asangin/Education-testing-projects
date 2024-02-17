Feature: Menu management

  Background: Run before each scenario
    Given I have a menu item with name "Chicken Sandwich" and price 12
    When I add that menu item
    Then Menu Item with name "Chicken Sandwich" should be added

  @SmokeTests
  Scenario: Add a menu item
    Given I have a menu item with name "Cucumber Sandwich" and price 20
    When I add that menu item
    Then Menu Item with name "Cucumber Sandwich" should be added

  @RegressionTests
  Scenario: Add another menu item
    Given I have a menu item with name "Cucumber Salad" and price 15
    When I add that menu item
    Then Menu Item with name "Cucumber Salad" should be added

  @NightlyBuildTest @RegressionTests
  Scenario: Add specific menu item
    Given I have a menu item with name "Chicken Sandwich" and price 12
    When I add that menu item
    Then Menu Item with name "Chicken Sandwich" should be added