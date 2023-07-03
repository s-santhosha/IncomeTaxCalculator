Feature: Income tax slab rates and slabs

  Description: The purpose of this feature is to test various
  income tax slabs application depending on the resident status

  Background: User navigates to Income Tax Calculator application
    Given I navigate to the income tax calculator application
    When I select Simple tax calculator
    Then I can view the "Simple tax calculator"

  @income-tax-resident-full-year
  Scenario Outline: Calculate Income Tax for various years for resident
    Given I am on income tax calculator
    When I select income year "<year>"
    And I select taxable income "<taxable income>" for the year
    And I select residency status as "Resident for full year"
    Then I click on submit
    And I verify the estimated tax as "<estimated tax>" on taxable income

    Examples:
      | year    | taxable income | estimated tax |
      | 2013-14 | 100000         | $24,947.00    |
      | 2022-23 | 500000         | $195,667.00   |
      | 2018-19 | 50000          | $7,797.00     |


  @income-tax-non-resident-full-year
  Scenario Outline: Calculate Income Tax for various years for non-resident
    Given I am on income tax calculator
    When I select income year "<year>"
    And I select taxable income "<taxable income>" for the year
    And I select residency status as "Non-resident for full year"
    Then I click on submit
    And I verify the estimated tax as "<estimated tax>" on taxable income

    Examples:
      | year    | taxable income | estimated tax |
      | 2013-14 | 100000         | $33,400.00    |
      | 2022-23 | 500000         | $205,200.00   |
      | 2018-19 | 50000          | $16,250.00    |

  @income-tax-part-year-resident
  Scenario Outline: Calculate Income Tax for various years for part-year resident
    Given I am on income tax calculator
    When I select income year "<year>"
    And I select taxable income "<taxable income>" for the year
    And I select residency status as "Part-year resident"
    And I select number of months "<months>" being resident
    Then I click on submit
    And I verify the estimated tax as "<estimated tax>" on taxable income

    Examples:
      | year    | taxable income | months | estimated tax |
      | 2013-14 | 100000         | 8      | $25,246.82    |
      | 2022-23 | 40000          | 10     | $4,291.91     |
      | 2018-19 | 50000          | 6      | $8,246.92     |