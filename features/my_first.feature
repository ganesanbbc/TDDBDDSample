Feature: Login feature
As a mobile application user,
I want to see the option to Sign-In or Register in the welcome screen
As an user want to do the login
As an user to see the warning dialog when enters the invalid credential
As an user to retain my last session within 1hr
As an user to see the welcome page if app does not used within 1hr
I want to see the landing page and have the logout option
I want to logout from the application


Scenario: 1) I want to see the options to Login or Register in the Welcome Screen
    Given I wait for the "MainActivity" screen to appear
    Then  I wait for the "btn_login" button to appear
    And I wait for the "btn_register" button to appear

Scenario: 2) I want to see the Login Page
    Given I wait for the "MainActivity" screen to appear
    Then I press the "Login" button
    Then I wait for the view with id "fragment_login" to appear

Scenario: 3a) I want to see warning dialog when I enter invalid credential
    Given I am on the Login Page
    When I enter text "invalid_username" into field with id "edt_username"
    And I enter text "invalid_password" into field with id "edt_password"
    And I hide the keyboard
    And I press the "Login" button
    Then I wait for progress
    Then I should see "Please enter correct credentials."
    Then I wait
    Then I press the "Ok" button

Scenario: 3b) I want to login and see the landing page
    Given I am on the Login Page
    When I enter text "cognizant" into field with id "edt_username"
    And I enter text "cts100%" into field with id "edt_password"
    And I hide the keyboard
    And I press the "Login" button
    Then I wait for progress
    Then I wait for the view with id "fragment_landing" to appear

#This could be clubbed with 3b
Scenario: 4) I want to see the Landing Page and the option to Log Out
    Given I am on the Landing Page
    Then I should see "Welcome to myApp"
    And I wait for the "btn_logout" button to appear

@cleanup_after_run @init_pre_hour
Scenario: 5) I am on the Landing Page and when I logout I am taken to the welcome screen
    Given I am on the Landing Page
    And I wait for the "btn_logout" button to appear
    When I press the "Logout" button
    Then I wait for the view with id "fragment_welcome" to appear

@cleanup_after_run @init_post_hour
Scenario: 6) I am taken to the Landing Page directly if I have logged in less than an hour
    Given I am logged in for less than an hour
    Then I wait for the view with id "fragment_landing" to appear

Scenario: 7) I am logged out and taken to the Welcome Page directly if I have logged in more than an hour earlier
    Given I am logged in for more than an hour
    Then I wait for the view with id "fragment_welcome" to appear


