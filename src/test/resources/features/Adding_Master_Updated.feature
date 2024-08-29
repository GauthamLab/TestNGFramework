#Author: gautham murugappan
@addMaster
Feature: Feature file to add master and delete the existing master

  @addMasterDryRun1
  Scenario: Load data from Excel workbook
    Given I load the Excel workbook "C:\Users\sachina\git\TestNGFramework\src\test\resources\testData\TitleDataSheet.xlsx" and sheet "TitleMaster"

  @addMasterDryRun1
  Scenario Outline: Login to Application
    Given I am on crm page
    Given Login with username and password for the test case "<TestCaseId>"
    Then Click LoginButton

    Examples: 
      | TestCaseId |
      | TC_001     |

  @addMasterDryRun
  Scenario Outline: INSERT
    Given Select Branch "<Branch>"
    When Select Create Title
    Then Enter Title Value "<Title>"
    Then Select Save
    Then Check that saved successfully is getting displayed

    Examples: 
      | Branch   | Title                         |
      | Columbus | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: ALREADY EXISTS in INSERT
    Then Enter Title Value "<Title>"
    Then Select Save
    And Check that Already exist modal is getting displayed

    Examples: 
      | Branch | Title                         |
      | Akron  | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: To Check CloseButton Logic without Data
    Then Enter Title Value "<Title>"
    Then Select Cancel

    Examples: 
      | Branch | Title                         |
      | Akron  | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: To Check the created title is available in the list
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"

    Examples: 
      | Branch | Title                         |
      | Akron  | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario: Active to In-active Status Check
    Then Select active to inactive
    Then Check that Made Inactive successfully is getting displayed

  @addMasterDryRun
  Scenario Outline: UPDATE With In-Active Status
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"
    Then Select Edit
    Then Enter Title Value "<TitleUpdated>"
    Then Select Save
    Then Check that saved successfully is getting displayed

    Examples: 
      | Branch | TitleUpdated                         | Title                         |
      | Akron  | Designee for Ali Karaki, P.E.Updated | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: In-Active to active Status Check
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"
    Then Select inactive to active
    Then Select Edit
    Then Enter Title Value "<TitleActive>"
    Then Select Save
    Then Check that saved successfully is getting displayed

    Examples: 
      | Branch | TitleActive                                | Title                         |
      | Akron  | Designee for Ali Karaki, P.E.UpdatedActive | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: Update with InUse status
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"
    Then Select Edit
    Then Enter Title Value "<TitleInUse>"
    Then Select Save
    Then Check that saved successfully is getting displayed

    Examples: 
      | TitleInUse                              | Title                         |
      | Designee for Ali Karaki, P.E.titleInUse | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: Delete the Title
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"
    Then Select active to inactive
    Then Check that Made Inactive successfully is getting displayed
    And Delete The Title
    Then Verfiy Title is Deleted

    Examples: 
      | TitleInUse                              | Title                         |
      | Designee for Ali Karaki, P.E.titleInUse | Designee for Ali Karaki, P.E. |

  @addMasterDryRun
  Scenario Outline: FieldValidation
    Then Enter Title Value "<Title>"
    Then Select Save
    Then Search the title which is added "<TitleDataValidation>"
    And Verify title is fetched "<TitleDataValidation>"
    Then Check that application is allowing only fifty charcters "<TitleDataValidation>"

    Examples: 
      | Title                                               | TitleDataValidation                                |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxy | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwx |

  @addMasterDryRun
  Scenario Outline: FieldValidation
    Then Enter Title Value "<Title>"
    Then Select Save
    Then Check that title is required is getting displayed

    Examples: 
      | Title |
      |       |

  @addMasterDryRun
  Scenario Outline: Delete the Title
    Then Search the title which is added "<Title>"
    And Verify title is fetched "<Title>"
    Then Select active to inactive
    Then Check that Made Inactive successfully is getting displayed
    And Delete The Title
    Then Verfiy Title is Deleted

    Examples: 
      | Title                                              |
      | Designee for Ali Karaki, P.E.titleInUse            |
      | Designee for Ali Karaki, P.E.                      |
      | ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwx |
      | Designee for Ali Karaki, P.E.UpdatedActive         |
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
