package org.fundacionjala.pivotal.stepdef.ui.workspace;

import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkSpaces;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceDashboard;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceSettings;
import org.fundacionjala.pivotal.pages.workspace.WorkspacesCreateForm;
import org.fundacionjala.pivotal.util.DataInterpreter;
import org.fundacionjala.pivotal.util.Helper;

/**
 * Created by pivotal-test Team.
 */
public class WorkspaceSteps {
    private Dashboard dashboard;
    private Helper helper;
    private WorkSpaces workspace;
    private WorkspaceDashboard workspaceDashboard;
    private WorkspacesCreateForm workspacesCreateForm;
    private WorkspaceSettings workspaceSettings;

    /**
     * Step definition constructor using dependence injection.
     *
     * @param dashboard            is the dashboard instance.
     * @param workspacesCreateForm is the workspaces creation form instance.
     * @param helper               is the helper is instance.
     */
    public WorkspaceSteps(Dashboard dashboard, WorkspacesCreateForm workspacesCreateForm, Helper helper) {
        this.dashboard = dashboard;
        this.helper = helper;
        this.workspacesCreateForm = workspacesCreateForm;
    }

    /**
     * Step definition that perform the navigation to workspace tab.
     */
    @And("^The user click on the workspace$")
    public void theUserClickOnTheWorkspace() {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
    }

    /**
     * Step definition that perform the navigation to create workspace button.
     */
    @And("^clicks on the new workspace button$")
    public void theUserClickOnTheNewWorkspaceButton() {
        workspacesCreateForm = workspaceDashboard.clickCreateWorkspaceBtn();
    }

    /**
     * Step definition that perform the create new Workspace.
     *
     * @param body is the attributes map to use.
     */
    @When("^sets workspace with$")
    public void theUserCreateANewWorkspaceWithTheFollowingParameters(Map<String, String> body) {
        workspacesCreateForm.setNameInputField(DataInterpreter.getValue(body.get("name")).toString());
        workspacesCreateForm.clickCreateButton();
        workspace = new WorkSpaces();
        helper.setWorkspaceVariable(body.get("name"));


    }

    /**
     * Step definition that perform navigate to workspace tab.
     */
    @And("^goes to workspace tab$")
    public void goToDashboardWorkspace() {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
    }

    /**
     * Step definition that perform setting workspace.
     *
     * @param nameWorkspace is the name workspace.
     */
    @When("^opens the workspace settings created as \"([^\"]*)\"$")
    public void theUserEnterToWorkspaceSettingPage(String nameWorkspace) {
        workspaceDashboard = dashboard.clickWorkspaceBtn();
        workspaceSettings = workspaceDashboard.selectWorkspace(DataInterpreter.getValue(nameWorkspace).toString());
    }

    /**
     * Step definition modify name workspace.
     *
     * @param newName is the new name workspace.
     */
    @And("^modify the name workspace to \"([^\"]*)\"$")
    public void modifyTheNameWorkspaceTo(String newName) {
        helper.setWorkspaceVariable(newName);
        workspaceSettings.updateName(newName);
        workspaceSettings.clickSaveButton();
    }

    /**
     * Step definition perform delete link.
     */
    @And("^delete the workspace$")
    public void delete() {
        workspaceSettings.clickDeleteLink();
        workspaceSettings.clickConfirmDeleteButton();
    }

    /**
     * Step definition that clicks on the add Projects button.
     */
    @And("^clicks on the add projects button$")
    public void clicksOnTheAddProjectsButton() {
        workspace.clickAddProjectsButton();
    }

    /**
     * Step definition that clicks on the projects DropdownButton.
     */
    @And("^clicks on the projects dropdown button$")
    public void clicksOnTheProjectsDropdownButton() {
        workspace.clickProjectsDropdown();
    }

    /**
     * Step definition that selects the project with the name.
     *
     * @param name name of the project.
     */
    @And("^select the project with the name \"([^\"]*)\"$")
    public void selectTheProjectWithTheName(String name) {
        workspace.clickProjectsDropdown();
        workspace.clickSelectedProjectFromTheDropDown(DataInterpreter.getValue(name).toString());
        helper.setProjectVariable(DataInterpreter.getValue(name).toString());
    }

    /**
     * Step definition that clicks on the save workspace changes button.
     */
    @And("^clicks on the Save Workspace Changes button$")
    public void clicksOnTheSaveWorkspaceChangesButton() {
        workspace.clickSaveWorkspaceChangesButton();
    }
}
