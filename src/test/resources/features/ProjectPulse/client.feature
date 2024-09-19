#Author: gautham murugappan  #C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData
@projectPulseClient
Feature: Feature file to Check Client Functionality

  @PPLogin
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData\ProjectPulse.xlsx" and sheet "Login"

  @PPLogin
  Scenario Outline: Login to Application
    Given I am on Project Pulse Page
    Given Login with username and password for the test case "<TestCaseId>"
    Then Click LoginButton

    Examples: 
      | TestCaseId |
      | TC_001     |

  @PPClient
  Scenario Outline: Navigate to Client section and update
    Given Select clinet and enter field values "<TestCaseId>"

    Examples: 
      | TestCaseId |
      | TC_002     |

  Scenario Outline: Navigate to Client section and select update and close
    Given Select client from list "<TestCaseId>"
    And Enter the values to the fields "<TestCaseId>"

    Examples: 
      | TestCaseId |
      | TC_003     |

  Scenario Outline: Search For certain client and chnage the status from active to non active
    Given Select client by search and change active to non active and delete the record "<TestCaseId>"
    Examples: 
      | TestCaseId |
      | TC_003     |
