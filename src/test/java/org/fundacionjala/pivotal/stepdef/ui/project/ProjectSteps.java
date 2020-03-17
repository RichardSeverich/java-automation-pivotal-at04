package org.fundacionjala.pivotal.stepdef.ui.project;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectAttributes;
import org.fundacionjala.pivotal.pages.project.ProjectCreateForm;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Steps for Project.
 */
public class ProjectSteps {

    private Dashboard dashboard;
    private ProjectCreateForm projectCreateForm;
    private Helper helper;
    private ProjectSettingsForm projectSettingsForm;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard is the dashboard instance.
     * @param helper    is the helper utility class instance.
     */
    public ProjectSteps(Dashboard dashboard, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
    }

    /**
     * Step definition that perform the click on the new project button.
     */
    @And("^click on the new project button$")
    public void clickOnTheNewProjectButton() {
        projectCreateForm = dashboard.clickProjectBtn();
    }

    /**
     * Step definition that perform the create new Project actions.
     *
     * @param map is the attributes map to use.
     */
    @When("^sets project with$")
    public void theUserCreateANewProjectWithTheFollowingParameters(Map<ProjectAttributes, String> map) {
        projectCreateForm.createProject(map);
        helper.setProjectVariable(map.get(ProjectAttributes.NAME));
        helper.setAccountVariable(map.get(ProjectAttributes.ACCOUNT));
    }

    /**
     * Step definition that perform the click on settings project icon.
     *
     * @param data is the data to be entered.
     */
    @When("^opens the project settings created as \"([^\"]*)\"$")
    public void theUserEntersToSettingsPage(String data) {
        projectSettingsForm = dashboard.clickProjectConfig(DataInterpreter.getValue(data).toString());
    }

    /**
     * Step definition that perform the project deletion.
     */
    @And("^delete the Project$")
    public void deleteTheProject() {
        dashboard = projectSettingsForm.deleteProject();
    }

    /**
     * Step definition that perform the project name modification.
     *
     * @param newName is the new name for the project.
     */
    @And("^modify the name to \"([^\"]*)\"$")
    public void modifyTheNameTo(String newName) {
        helper.setProjectVariable(newName);
        projectSettingsForm.modifyProjectName(newName);
    }

    /**
     * Step definition that perform the navigation to Project Setting Page.
     */
    @And("^goes to Project Settings Page$")
    public void goesToProjectSettingsPage() {
        projectSettingsForm = new Project().clickSettingsTabButton();
    }
}
