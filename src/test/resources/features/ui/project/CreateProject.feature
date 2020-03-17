@bvt
Feature: Create Project

  Background:
    Given goes to dashboard
    And click on the new project button

  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with default settings successfully
    When sets project with
      | NAME    | AutomationProject001 |
      | ACCOUNT | AutomationAccount001 |
    Then new project name is displayed in the project main page
    And goes to dashboard
    Then project is displayed in the dashboard

  @DeleteSingleProject @DeleteAccount
  Scenario: The user can create a project with public privacy
    When sets project with
      | NAME    | AutomationProject002 |
      | ACCOUNT | AutomationAccount002 |
      | PRIVACY | public               |
    Then new project name is displayed in the project main page
    And goes to dashboard
    Then project is displayed in the dashboard
