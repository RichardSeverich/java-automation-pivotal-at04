package org.fundacionjala.pivotal.stepdef.ui;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.core.util.Navigator;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Class containing Common Steps.
 */
public class CommonSteps {

    private Dashboard dashboard;
    private Project project;
    private Assertion assertion;

    /**
     * This constructor using dependence injection.
     *
     * @param dashboard is the dashboard page object.
     * @param helper is Helper.
     */
    public CommonSteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.assertion = helper.getAssertion();
    }

    /**
     * Step definition that perform the navigate to dashboard action.
     */
    @And("^goes to dashboard$")
    public void goToDashboard() {
        Navigator.loadDashboardPage();
    }

    /**
     * this Step definition enter to project page.
     *
     * @param name this variable contains the project name.
     */
    @When("^opens the project created as \"([^\"]*)\"$")
    public void openTheProjectCreatedAs(String name) {
        project = dashboard.enterToProject(DataInterpreter.getValue(name).toString());
    }

    /**
     * this Step definition enter to story page.
     *
     * @param name this variable contains the story name.
     */
    @And("^opens the story created as \"([^\"]*)\"$")
    public void opensTheStoryCreatedAs(String name) {
        project.enterExistingStory(DataInterpreter.getValue(name).toString());
    }

    /**
     * Step definition that perform the assertion message error.
     *
     * @param errorMessage that should be displayed.
     */
    @Then("^validation error message \"([^\"]*)\" should be displayed$")
    public void verifyThatValidationErrorMessageIsDiplayed(String errorMessage) {
        assertion.assertTrue(CommonActions.getErrorMessage().contains(errorMessage));
    }

    /**
     * This method executes all soft asserts.
     */
    @And("^Assert all$")
    public void assertAll() {
        if (assertion instanceof SoftAssert) {
            ((SoftAssert) assertion).assertAll();
        }
    }
}
