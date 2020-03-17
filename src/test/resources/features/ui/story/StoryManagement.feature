Feature: Delete and edit story

  Background:
    Given a "POST" request to "/projects" with
      | name | ProjectManageStory |
    And the status code should be 200
    And stored as [Project]
    And a "POST" request to "/projects/[Project.id]/stories" with
      | name | MyStoryApi |
    And the status code should be 200
    And stored as [Story]
    And goes to dashboard
    And opens the project created as "[Project.name]"
    And opens the story created as "[Story.name]"

  @DeleteProjectsByPrefix
  Scenario: The user can delete an existing story
    When delete the Story
    Then the "[Story.name]" is not displayed in Project Page

  @DeleteProjectsByPrefix
  Scenario: the user can modify an existing story
    When sets story with
      | STORY_NAME        | MyAutomatedStoryName   |
      | STORY_NAME        | MyAutomatedStoryName   |
      | STORY_TYPE        | FEATURE                |
      | STORY_POINTS      | ONE                    |
      | STORY_BLOCKERS    | MyAutomatedBlockers    |
      | STORY_DESCRIPTION | MyAutomatedDescription |
      | STORY_LABEL       | MyAutomatedLabel       |
    Then story is displayed in the project page
