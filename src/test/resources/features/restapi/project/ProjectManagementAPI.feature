@bvt
Feature: Project Management using REST API

  Background:
    Given a "POST" request to "/projects" with
      | name | ProjectToManage |
    And the status code should be 200
    And stored as [ProjectManagement]

  Scenario: An existing Project can be deleted using REST API
    When a "DELETE" request to "/projects/[ProjectManagement.id]"
    Then the status code should be 204

  @DeleteProject
  Scenario: The name of an existing project can be edited using REST API
    When a "PUT" request to "/projects/[ProjectManagement.id]" with
      | name | Modified |
    Then the status code should be 200

  @DeleteProject
  Scenario: The data of an existing project can be acquired using REST API
    When a "GET" request to "/projects/[ProjectManagement.id]"
    Then the status code should be 200
