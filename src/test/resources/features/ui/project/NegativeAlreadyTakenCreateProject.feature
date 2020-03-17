Feature: Negative Name Already Taken Create Project

  Background:
    Given goes to dashboard
    And click on the new project button
    And sets project with
      | NAME    | ProjectToManage      |
      | ACCOUNT | AutomationAccount001 |
    And goes to dashboard
    And click on the new project button

  @DeleteAccount @DeleteProjectsByPrefix
  Scenario: The user can't rename a project if it's already taken
    When sets project with
      | NAME    | ProjectToManageAnother |
      | ACCOUNT | AutomationAccount001   |
    And new project name is displayed in the project main page
    And goes to Project Settings Page
    Then modify the name to "ProjectToManage"
    And error messages should display
    And modify the name to ""
    And error messages should display

  @DeleteAccount @DeleteProjectsByPrefix
  Scenario: The user can't create a project with the name already taken
    When sets project with
      | NAME    | ProjectToManage      |
      | ACCOUNT | AutomationAccount001 |
    Then error messages with name already taken should be displayed
