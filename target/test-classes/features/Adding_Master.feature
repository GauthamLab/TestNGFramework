#Author: gautham murugappan
Feature: Feature file to add master and delete the existing master 
  
  As a user i will create master 
  i will delete the master 

  Background: 
    Given I am on crm page

  @addMaster
  Scenario Outline: Adding Master
    Given I have selected Add Title
    Then I have entered Title "<title>"
    And Selected AddButton
    Then Verify that "<title>" is added
    And Delete The created title

    Examples: 
      | title            |
      | AirportLaneMaster|
  #@tag2
  #Scenario Outline: Navigate to the forgotten password page
    #Given I click on "Forgotten Password" Link
    #Then I should be redirected to password reset page
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
