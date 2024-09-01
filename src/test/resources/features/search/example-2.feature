Feature: Search by1
  Scenario Outline: Searching for 'Serenity'
    Given Navigate to search page
    And Search by keyword "<search>"
    Then Verify search result "<expected>"
    Examples:
    |search           | expected|
    |   Facebook     |       Facebook   |
    |   Facebook     |       Facebook   |
    |   Facebook     |       Facebook   |
    |   Facebook     |       Facebook   |
    |   Facebook     |       Facebook   |