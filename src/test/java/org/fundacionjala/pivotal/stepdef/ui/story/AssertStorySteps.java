package org.fundacionjala.pivotal.stepdef.ui.story;

import cucumber.api.java.en.Then;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.story.StoryBoard;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;

/**
 * Class containing Asserts Story steps Page.
 */
public class AssertStorySteps {

    private Project project;
    private Helper helper;
    private Assertion assertion;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param project is the Project class instance.
     * @param helper  is the helper utility class instance.
     */
    public AssertStorySteps(Project project, Helper helper) {
        this.project = project;
        this.helper = helper;
        this.assertion = helper.getAssertion();
    }

    /**
     * Step definition that perform the assertion.
     */
    @Then("^story is displayed in the project page$")
    public void newStoryNameIsDisplayedInTheProjectPage() {
        assertion.assertTrue(project.isVisibleStory(helper.getStoryVariable()));
    }

    /**
     * Step definition that perform the assertion.
     *
     * @param data contains the name of variable.
     */
    @Then("^the \"([^\"]*)\" is not displayed in Project Page$")
    public void theIsNotDisplayedInProjectPage(String data) {
        assertion.assertFalse(project.isVisibleStory(DataInterpreter.getValue(data).toString()));
    }

    /**
     * Step definition validation error message.
     */
    @Then("^validation error message should be displayed$")
    public void verifyThatValidationErrorMessageIsDiplayed() {
        assertion.assertTrue(StoryBoard.validationError());
    }
}
