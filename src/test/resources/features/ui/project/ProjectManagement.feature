Feature: Project Management

  Background:
    Given a "POST" request to "/projects" with
      | name | ProjectToManage |
    And the status code should be 200
    And stored as [ProjectToManage]
    And goes to dashboard
    And opens the project settings created as "[ProjectToManage.name]"

  @DeleteProjectsByPrefix
  Scenario: The user can delete an existing project
    When delete the Project
    Then message "[ProjectToManage.name] was successfully deleted." should be displayed
    And the "[ProjectToManage.name]" is not displayed in Dashboard

  @DeleteProjectsByPrefix
  Scenario: The user can modify the name an existing project
    When modify the name to "AT-04ProjectModified"
    Then message "Changes saved." should appear in settings page
    And goes to dashboard
    Then "[ProjectToManage.name]" is not displayed in dashboard
    And project is displayed in dashboard