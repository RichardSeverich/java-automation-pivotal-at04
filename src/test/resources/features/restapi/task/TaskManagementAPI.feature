@bvt
Feature: Delete and Edit Task using REST API

  Background:
    Given a "POST" request to "/projects" with
      | name | MyProjectApi |
    Then the status code should be 200
    And stored as [Project]
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    Then the status code should be 200
    And stored as [MyStory]
    And a "POST" request to "/projects/[Project.id]/stories/[MyStory.id]/tasks" with
      | description | I have to do this |
    Then the status code should be 200
    And stored as [MyTask]


  @DeleteProject
  Scenario: An existing Task can be deleted using REST API
    When a "DELETE" request to "/projects/[Project.id]/stories/[MyStory.id]/tasks/[MyTask.id]"
    Then the status code should be 204

  @DeleteProject
  Scenario: The name of an existing project can be edited using REST API
    When a "PUT" request to "/projects/[Project.id]/stories/[MyStory.id]/tasks/[MyTask.id]" with
      | description | MyDescription |
    Then the status code should be 200