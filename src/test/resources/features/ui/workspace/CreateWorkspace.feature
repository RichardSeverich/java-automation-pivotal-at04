Feature: Create Workspace

  Background:
    Given goes to dashboard
    And  goes to workspace tab
    And clicks on the new workspace button

  @DeleteSingleWorkspace
  Scenario: The user can create a workspace with default setting successfully
    When sets workspace with
      | name | AT-04MyWorkspace |
    Then New workspace name is displayed in the workspace main page
    And goes to dashboard
    And goes to workspace tab
    And workspace is displayed in the dashboard

  Scenario: Verify if the user can't created a new workspace with the field empty name
    When sets workspace with
      | name |  |
    Then error message "Workspace name can't be blank."
