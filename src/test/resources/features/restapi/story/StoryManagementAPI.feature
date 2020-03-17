@bvt
Feature: Delete and edit Story using REST API

  Background:
    When a "POST" request to "/projects" with
      | name | MyProjectApi |
    And stored as [Project]
    Then the status code should be 200
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    And stored as [Story]
    Then the status code should be 200

  @DeleteProject
  Scenario: An existing Story can be deleted using REST API
    When a "DELETE" request to "/projects/[Project.id]/stories/[Story.id]"
    Then the status code should be 204

  @DeleteProject
  Scenario: The data of an existing project can be acquired using REST API
    When a "GET" request to "/projects/[Project.id]/stories/[Story.id]"
    Then the status code should be 200

  @DeleteProject
  Scenario: The name of an existing project can be edited using REST API
    When a "PUT" request to "/projects/[Project.id]/stories/[Story.id]" with
      | name | MyStoryModifyApi |
    Then the status code should be 200



