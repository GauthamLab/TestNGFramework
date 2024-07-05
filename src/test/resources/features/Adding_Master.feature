#Author: gautham murugappan
@addMaster1
Feature: Feature file to add master and delete the existing master 

  Scenario Outline: Login to Application 
  Given I am on crm page
  Given Login with "<username>" and "<password>"
  Then 	Click LoginButton 
  Examples:
  |username|password |
  | CZ     |V6bleSSed|
  
  Scenario Outline: INSERT 
  Given Select Branch "<Branch>"
  When  Select Create Title
  Then 	Enter Title Value "<Title>"
  Then 	Select Save
  Examples: 
      | Branch|Title                        |
      | Akron |Designee for Ali Karaki, P.E.|
      
 Scenario: ALREADY EXISTS in INSERT 
  Then 	Select Save
  And 	Check that Already exist modal is geting displayed    
  
  Scenario: To Check CloseButton Logic without Data 
  Then 	Select Cancel    
  
  Scenario: To Check the created title is available in the list 
  Then Search the title which is added 
  And Verify title is fecthed 
  
  Scenario Outline: Update with InUse status
  Given Select the record which have USED status 
  Then  Change the title to new title"<newTitle>"
   Then Select Update
  Examples: 
     |newTitle                     |
     |Designee for Ali Karaki, P.E.|
  
   
  #Scenario Outline: Adding Master
    #Given I have selected Add Title
    #Then I have entered Title "<title>"
    #And Selected AddButton
    #Then Verify that "<title>" is added
    #And Delete The created title
#
    #Examples: 
      #| title            |
      #| AirportLaneMaster|
  #@tag2
  #Scenario Outline: Navigate to the forgotten password page
    #Given I click on "Forgotten Password" Link
    #Then I should be redirected to password reset page
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
