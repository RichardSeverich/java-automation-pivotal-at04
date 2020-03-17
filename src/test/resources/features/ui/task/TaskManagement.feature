Feature: Delete and edit task

  Background:
    Given a "POST" request to "/projects" with
      | name | ProjectManageTask |
    And the status code should be 200
    And stored as [Project]
    When a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    And the status code should be 200
    And stored as [Story]
    When a "POST" request to "/projects/[Project.id]/stories/[Story.id]/tasks" with
      | description | I have to do this |
    Then the status code should be 200
    And stored as [MyTask]
    When goes to dashboard
    And opens the project created as "[Project.name]"
    And opens the story created as "[Story.name]"

  @DeleteProjectsByPrefix
  Scenario: The user can delete an existing task
    When delete the task "[MyTask.description]"
    Then the "[MyTask.description]" should not be displayed
