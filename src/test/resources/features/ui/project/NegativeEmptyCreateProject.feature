Feature: Negative Empty Create Project

  Background:
    Given goes to dashboard
    And click on the new project button

  @SoftAssert
  Scenario: The user can't create a project without filling the project name or selecting an account
    When sets project with
      | NAME    |  |
      | ACCOUNT |  |
    Then error messages for empty values should be displayed
