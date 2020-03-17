package org.fundacionjala.pivotal.pages.dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.pages.accounts.Account;
import org.fundacionjala.pivotal.pages.profile.Profile;
import org.fundacionjala.pivotal.pages.project.Project;
import org.fundacionjala.pivotal.pages.project.ProjectCreateForm;
import org.fundacionjala.pivotal.pages.project.ProjectSettingsForm;
import org.fundacionjala.pivotal.pages.signin.SignIn;
import org.fundacionjala.pivotal.pages.workspace.WorkspaceDashboard;

/**
 * Created by pivotal-test Team.
 */
public class Dashboard extends BasePage {

    @FindBy(css = "div[data-aid='ProfileDropdown'] > button")
    private WebElement usernameLabel;

    @FindBy(css = "button[data-aid='ProfileDropdown__signout']")
    private WebElement signOutButton;

    @FindBy(css = "a[data-aid='ProfileDropdown__profile']")
    private WebElement profileButton;

    @FindBy(id = "create-project-button")
    private WebElement projectBtn;

    @FindBy(className = "tc_header_text_logo")
    private WebElement logoLabel;

    @FindBy(className = "projectTileHeader__projectName")
    private List<WebElement> projectTitlesList;

    @FindBy(id = "notice")
    private WebElement noticeLabel;

    @FindBy(css = "div.Dashboard__Tabs span")
    private List<WebElement> menuLink;

    @FindBy(className = "notice")
    private WebElement message;

    @FindBy(css = "a[href='/accounts']")
    private WebElement accountListItem;

    /**
     * This method perform a click on the User Name label.
     */
    private void clickUsernameBtn() {
        CommonActions.clickButton(usernameLabel);
    }

    /**
     * This method perform a click on the Sign Out Button.
     */
    private void clickSignOutBtn() {
        CommonActions.clickButton(signOutButton);
    }

    /**
     * This method perform a click on the Profile button.
     *
     * @return profile object page.
     */
    private Profile clickProfileButton() {
        clickUsernameBtn();
        CommonActions.clickButton(profileButton);
        return new Profile();
    }

    /**
     * This method perform a click on the Create New Project button.
     *
     * @return a Create Project Form instance.
     */
    public ProjectCreateForm clickProjectBtn() {
        CommonActions.clickButton(projectBtn);
        return new ProjectCreateForm();
    }

    /**
     * This method perform a click on a Project Config icon of  a specified Project name.
     *
     * @param name is the name of the Project.
     * @return a Project Settings Form class instance.
     */
    public ProjectSettingsForm clickProjectConfig(String name) {
        String xpath = String.format("//a[text()='%s']/following::a[contains(@class,'SettingsIcon')]", name);
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        CommonActions.clickButton(webElement);
        return new ProjectSettingsForm();
    }

    /**
     * This method perform a click on the Logo label.
     *
     * @return a DashboardMenu class instance.
     */
    public DashboardMenu clickLogoLabel() {
        CommonActions.clickButton(logoLabel);
        return new DashboardMenu();
    }

    /**
     * This method perform a click on the Account list element.
     *
     * @return a Account class instance.
     */
    public Account clickAccountListItem() {
        clickUsernameBtn();
        CommonActions.clickButton(accountListItem);
        return new Account();
    }

    /**
     * This verifies if the correct user is logged.
     *
     * @param username user name.
     * @return true if is correct user or false if it is not.
     */
    public boolean isCorrectUserLogged(String username) {
        Dashboard dashboard = new Dashboard();
        return dashboard.clickProfileButton().isCorrectUserLogged(username);
    }

    /**
     * This method closes a existing session.
     *
     * @param signIn is signIn page object.
     * @return singIn page Object.
     */
    public SignIn signOut(SignIn signIn) {
        clickUsernameBtn();
        clickSignOutBtn();
        return signIn;
    }

    /**
     * This method perform a search of a Project name in the Dashboard.
     *
     * @param name is the project name.
     * @return the search result.
     */
    public boolean isProjectFound(String name) {
        WebElement webElement = CommonActions.findWebElement(projectTitlesList, name);
        return webElement != null;
    }

    /**
     * This method enters to a project main page specified by the name parameter.
     *
     * @param nameProject is the project name.
     * @return a new Project instance.
     */
    public Project clickInProject(String nameProject) {
        String xpath = String.format("//a[text()='%s']", nameProject);
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        CommonActions.clickButton(webElement);
        return new Project();
    }

    /**
     * This method return the text content of the notice in Dashboard.
     *
     * @return the notice content.
     */
    public String getNoticeText() {
        return CommonActions.getTextContent(noticeLabel);
    }

    /**
     * This method enters to a project main page specified by the name parameter.
     *
     * @param nameProject is the project name.
     * @return a new Project instance.
     */
    public Project enterToProject(String nameProject) {
        String xpath = String.format("//a[text()='%s']", nameProject);
        WebElement webElement = webDriver.findElement(By.xpath(xpath));
        CommonActions.clickButton(webElement);
        return new Project();
    }

    /**
     * This method perform a click on the workspace tab.
     *
     * @return new instance od WorkspaceDashboard.
     */
    public WorkspaceDashboard clickWorkspaceBtn() {
        CommonActions.findWebElement(menuLink, "Workspaces").click();
        return new WorkspaceDashboard();
    }

    /**
     * This method return the text content of the notice in Dashboard.
     *
     * @return the notice content.
     */
    public String deleteMessageIsDisplayed() {
        return message.getText();
    }
}
