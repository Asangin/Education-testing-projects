Feature: Data Tables

  @ListOfStrings
  Scenario: Bill Amount Generation
    Given I placed an order for the following items
      | Cucumber Sandwich | 2 | 20 |
    When I generate the bill
    Then a bill for $40 should be generated


  @ListOfListsStrings
  Scenario: Bill Amount Generation
    Given I placed an order for the following items
      | Cucumber Sandwich | 2 | 20 |
      | Cucumber Salad    | 1 | 15 |
    When I generate the bill
    Then a bill for $55 should be generated


  @ListOfMapStrings
  Scenario: Bill Amount Generation
    Given I placed an order for the following items table
      | ItemName          | Units | UnitPrice |
      | Cucumber Sandwich | 2     | 20        |
      | Cucumber Salad    | 1     | 15        |
    When I generate the bill
    Then a bill for $55 should be generated