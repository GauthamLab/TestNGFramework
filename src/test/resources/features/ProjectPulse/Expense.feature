#Author: gautham murugappan  #C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData
@projectPulseExpense
Feature: Feature file to Check Employee Functionality

  @PPLoginEmp
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData\ProjectPulse.xlsx" and sheet "Expense"

  @PPLoginEmp
  Scenario Outline: Login to Application
    Given I am on Project Pulse Page
    Given Login with username and password for the test case "<TestCaseId>"
    Then Click LoginButton

    Examples: 
      | TestCaseId |
      | TC_001     |

  @PPClient
  Scenario Outline: Navigate to Location section and add location
    Given Select expense and enter field values "<TestCaseId>"
    Then Select Save on expense screen

    Examples: 
      | TestCaseId |
      | TC_002     |

  Scenario Outline: Navigate to emp section and select update and close
    Given Select record by expense "<TestCaseId>"
    And Update the expense values to the fields "<TestCaseId>"
    And Select expense Update button

    Examples: 
      | TestCaseId |
      | TC_003     |

  Scenario Outline: Search For certain emp and chnage the status from active to non active
    Given Select expense by search and change active to non active and delete the record "<TestCaseId>"
    And Make expense activeToInactive and Delete

    Examples: 
      | TestCaseId |
      | TC_003     |
