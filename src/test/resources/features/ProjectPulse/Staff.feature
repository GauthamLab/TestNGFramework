#Author: gautham murugappan  #C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData
@projectPulseStaff
Feature: Feature file to Check Employee Functionality

  @PPLoginEmp
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "C:\Users\Rajesh\git\TestNGFramework\src\test\resources\testData\ProjectPulse.xlsx" and sheet "Staff"

  @PPLoginEmp
  Scenario Outline: Login to Application
    Given I am on Project Pulse Page
    #Given Login with username and password for the test case "<TestCaseId>"
    Given Login with password for the test case "<TestCaseId>"
    Then Click ClickMeButton
    And Select Owner

    Examples: 
      | TestCaseId |
      | TC_001     |

  @PPClient
  Scenario Outline: Navigate to Location section and add location
    Given Select staff and enter field values "<TestCaseId>"
    Then Select Save on staff screen

    Examples: 
      | TestCaseId |
      | TC_002     |

  Scenario Outline: Navigate to emp section and select update and close
    Given Select record by staff "<TestCaseId>"
    And Update the staff values to the fields "<TestCaseId>"
    And Select staff Update button

    Examples: 
      | TestCaseId |
      | TC_003     |

  Scenario Outline: Search For certain emp and chnage the status from active to non active
    Given Select staff by search and change active to non active and delete the record "<TestCaseId>"
    And Make staff activeToInactive and Delete

    Examples: 
      | TestCaseId |
      | TC_003     |
