#Author: gautham murugappan
@projectPulse1
Feature: Feature file to Check login Functionality and Profile Section

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
