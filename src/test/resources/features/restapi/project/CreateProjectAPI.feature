@bvt
Feature: Create Project using REST API

  @DeleteProject
  Scenario: A Project can be created using REST API
    When a "POST" request to "/projects" with
      | name | CreateProjectAPI |
    Then the status code should be 200
    And stored as [ProjectAPI]
