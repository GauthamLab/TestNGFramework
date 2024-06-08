#Author: gautham murugappan
Feature: Login Functionallity for OpenCart E-mmerece Website
  
  As a user of opencart website
  I want to be able to login to my application
  So that I can acess my account - replated features and manage orders

  Background: 
    Given I am on the OpenCart Login page

  @Login
  Scenario Outline: Login with invalid credentials
    Given I have selected my account
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see an error message indicating "<error_message>"

    Examples: 
      | username          | password         | error_message                                         |
      | invalid@email.com | invalid password | Warning: No match for E-Mail Address and/or Password. |
      | invalid@email.com | Gautham11!       | Warning: No match for E-Mail Address and/or Password. |
  #@tag2
  #Scenario Outline: Navigate to the forgotten password page
    #Given I click on "Forgotten Password" Link
    #Then I should be redirected to password reset page
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
