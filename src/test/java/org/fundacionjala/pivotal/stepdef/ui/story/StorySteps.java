package org.fundacionjala.pivotal.stepdef.ui.story;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.story.StoryAttributes;
import org.fundacionjala.pivotal.pages.story.StoryBoard;
import org.fundacionjala.pivotal.pages.story.StoryDeleteDialog;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by pivotal-test Team.
 */
public class StorySteps {

    private Project project;
    private StoryBoard storyBoard;
    private Helper helper;

    /**
     * This constructor using dependence injection.
     *
     * @param project    is the Project page object.
     * @param storyBoard is the StoryBoard page object.
     * @param helper     is the helper utility class instance.
     */
    public StorySteps(Project project, StoryBoard storyBoard, Helper helper) {
        this.helper = helper;
        this.project = project;
        this.storyBoard = storyBoard;
    }

    /**
     * this Step definition create a story.
     *
     * @param storyAttributesMap this map contains the story attributes.
     */
    @When("^sets story with$")
    public void theUserSetStorySettings(Map<StoryAttributes, String> storyAttributesMap) {
        project = storyBoard.setStoryAttributes(storyAttributesMap);
        helper.setStoryVariable(storyAttributesMap.get(StoryAttributes.STORY_NAME));
    }

    /**
     * this Step definition deletes the story.
     */
    @And("^delete the Story$")
    public void andDeleteTheStory() {
        StoryDeleteDialog storyDeleteDialog = storyBoard.deleteStory();
        project = storyDeleteDialog.confirm();
    }

    /**
     * this Step definition performs click on the new story button.
     */
    @And("^clicks on the new story button$")
    public void clicksOnTheNewStoryButton() {
        storyBoard = project.clickAddStoryButton();
    }
}
