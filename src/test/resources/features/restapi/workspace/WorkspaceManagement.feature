@bvt
Feature: Delete Workspace using REST API

  Background:
    When a "POST" request to "/my/workspaces" with
      | name | MyWorkspace |
    Then the status code should be 200
    And stored as [Workspace]

  Scenario: An existing Workspace can be deleted using REST API
    When a "DELETE" request to "/my/workspaces/[Workspace.id]"
    Then the status code should be 204

  @DeleteWorkspace
  Scenario: The data of an existing workspace can be acquired using REST API
    When a "GET" request to "/my/workspaces/[Workspace.id]"
    Then the status code should be 200

#  @DeleteProject
#  Scenario: The name of an existing workspace can be edited using REST API
#    When a PUT request to "/my/workspaces/[Workspace.id]" with
#      | name | Workspace Modified |
#    Then the status code should be 200
