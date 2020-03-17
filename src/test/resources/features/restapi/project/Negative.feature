Feature: Can create a Project with an empty name using REST API

  Scenario: A Project can't be created with an empty name
    When a "POST" request to "/projects" with
      | name |  |
    Then the status code should be 400

  Scenario: A Project can't be created without parameters
    When a "POST" request to "/projects" with
      |  |  |
    Then the status code should be 400