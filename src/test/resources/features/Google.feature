Feature: Google search functionality

  @Regression
  Scenario Outline: Search a word on Google
    Given the user is on Google main page
    When the user search for <word>
    Then the <result> match the search criteria
    Examples:
      | word       | result                                          |
      | automation | Automation - The Car Company Tycoon Game en Steam |
