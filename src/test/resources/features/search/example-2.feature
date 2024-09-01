Feature: Search by1

  Scenario Outline: Searching for 'Serenity'
    Given Navigate to search page
    And Search by keyword "<search>"
    Then Verify search result "<expected>"
    Examples:
      | search   | expected |
      | Facebook | Facebook |
      | Facebook | Facebooks |
      | Facebook | Facebook |
      | Facebook | Facebooks |
      | Facebook | Facebook |

  Scenario: Data table example
    Given Search by keyword
      | store_ids | keyword       | page | limit |
      | 263       | API0000-DDO-L | 1    | 30    |