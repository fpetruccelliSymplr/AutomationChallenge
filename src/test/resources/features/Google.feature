Feature: Google search functionality

  @Regression
  Scenario: Search a word on Google
    Given the user is on Google main page
    When the user search for a word
    Then the results match the search criteria

