Feature: Workspace with a Project

  Background:
    Given a "POST" request to "/projects" with
      | name | MyProjectwork |
    And the status code should be 200
    And stored as [MyProject]
    And goes to dashboard
    And goes to workspace tab
    And clicks on the new workspace button

  @DeleteProjectsByPrefix @DeleteWorkspaceByPrefix
  Scenario: The user can create a workspace
    When sets workspace with
      | name | AT-04MyWorkspace |
    And clicks on the add projects button
    And select the project with the name "[MyProject.name]"
    And clicks on the Save Workspace Changes button
    Then the workspace with a project is displayed in the workspace main page
    And goes to dashboard
    And goes to workspace tab
    Then workspace with a "[MyProject.name]" is displayed in the dashboard
