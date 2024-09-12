#Author: gautham murugappan
@projectPulseClient
Feature: Feature file to Check Client Functionality 

  @PPLogin
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "E:\AutomationWorkSpace\ProjectPulse\TestNGFramework\src\test\resources\testData\ProjectPulse.xlsx" and sheet "Login"

  @PPLogin
  Scenario Outline: Login to Application
    Given I am on Project Pulse Page
    Given Login with username and password for the test case "<TestCaseId>"
    Then Click LoginButton

    Examples: 
      | TestCaseId |
      | TC_002     |
 @PPClient     
 Scenario: Navigate to Client section
    Given Select clinet and enter field values 
   
      
