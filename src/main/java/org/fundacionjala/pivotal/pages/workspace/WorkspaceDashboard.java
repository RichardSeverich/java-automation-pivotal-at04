package org.fundacionjala.pivotal.pages.workspace;

import java.util.List;

import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class contains Workspaces Dashboard Page.
 */
public class WorkspaceDashboard extends BasePage {

    @FindBy(className = "WorkspaceTile__name")
    private List<WebElement> workSpacesList;

    @FindBy(className = "WorkspaceTile__header")
    private List<WebElement> workSpacesSettingList;

    @FindBy(xpath = "//*[@id='create-workspace-button']")
    private WebElement createWorkspaceButton;

    /**
     * This method verify that a workspace displayed.
     *
     * @param workspaceName is the workspace name.
     * @return a WebElement.
     */
    public boolean workspaceIsDisplayed(String workspaceName) {
        return CommonActions.findWebElement(workSpacesList, workspaceName).isDisplayed();
    }

    /**
     * This method search a workspace and click on element.
     *
     * @param workspaceName is the workspace name.
     * @return a new instance of WorkspaceSetting.
     */
    public WorkspaceSettings selectWorkspace(String workspaceName) {
        StringBuilder selector = new StringBuilder();
        selector.append(String.format("//a[text()='%s']/following::a[contains(@class,'SettingsIcon')]", workspaceName));
        WebElement webElement = webDriver.findElement(By.xpath(selector.toString()));
        webElement.click();
        return new WorkspaceSettings();
    }

    /**
     * This method get click on create workspace button.
     *
     * @return new instance of WorkspacesCreateForm.
     */
    public WorkspacesCreateForm clickCreateWorkspaceBtn() {
        CommonActions.clickButton(createWorkspaceButton);
        return new WorkspacesCreateForm();
    }

    /**
     * This method verify that exist a workspace.
     *
     * @param workspaceName is the workspace name.
     * @return if the element is found.
     */
    public boolean isWorkspaceFound(String workspaceName) {
        WebElement webElement = CommonActions.findWebElement(workSpacesList, workspaceName);
        return webElement != null;
    }

    /**
     * This method verify that exist a workspace has the project.
     *
     * @param workspaceName is the workspace name.
     * @param projectName   is the project name.
     * @return if the element is found.
     */
    public boolean isWorkspaceHasTheProject(String workspaceName, String projectName) {
        StringBuilder selector = new StringBuilder();
        selector.append(String.format("//a[@class='WorkspaceTile__name' and text()='%s']/parent::div/"
                + "following-sibling::div/child::div/child::a[text()='%s']", workspaceName, projectName));
        WebElement webElement = webDriver.findElement(By.xpath(selector.toString()));
        return webElement != null;
    }
}
