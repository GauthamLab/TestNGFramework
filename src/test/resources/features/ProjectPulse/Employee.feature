#Author: gautham murugappan  #C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData
@projectPulseEmployee
Feature: Feature file to Check Employee Functionality

  @PPLogin
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData\ProjectPulse.xlsx" and sheet "Employee"

  @PPLogin
  Scenario Outline: Login to Application
    Given I am on Project Pulse Page
    Given Login with username and password for the test case "<TestCaseId>"
    Then Click LoginButton

    Examples: 
      | TestCaseId |
      | TC_001     |

  @PPClient
  Scenario Outline: Navigate to Location section and add location
    Given Select employee and enter field values "<TestCaseId>"
    Then Select Save Button on employee screen

    Examples: 
      | TestCaseId |
      | TC_002     |

  Scenario Outline: Navigate to Client section and select update and close
    Given Select record by search employee "<TestCaseId>"
    And Update the emp values to the fields "<TestCaseId>"
    And Select employee Update button

    Examples: 
      | TestCaseId |
      | TC_003     |

  Scenario Outline: Search For certain client and chnage the status from active to non active
    Given Select employee by search and change active to non active and delete the record "<TestCaseId>"

    Examples: 
      | TestCaseId |
      | TC_003     |