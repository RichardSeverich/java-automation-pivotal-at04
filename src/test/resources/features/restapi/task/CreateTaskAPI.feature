@bvt
Feature: Add Task in a Story

  Background:
    Given a "POST" request to "/projects" with
      | name | MyProjectApi |
    Then the status code should be 200
    And stored as [Project]
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    Then the status code should be 200
    And stored as [MyStory]

  @DeleteProject
  Scenario: A Task can be add in a Story
    When a "POST" request to "/projects/[Project.id]/stories/[MyStory.id]/tasks" with
      | description | I have to do this |
    Then the status code should be 200