package org.fundacionjala.pivotal.pages.workspace;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * It is the page of a selected workspace.
 */
public class WorkSpaces extends BasePage {

    @FindBy(className = "raw_context_name")
    private WebElement workSpacesName;

    @FindBy(css = "button[data-aid='edit-workspace']")
    private WebElement addProjectsButton;

    @FindBy(xpath = "//div[@title='Panel actions' and contains(@class,WorkspaceSidebar__projectsDropdown)]")
    private WebElement projectsDropdown;

    @FindBy(css = "button[class='save']")
    private WebElement saveWorkspaceChangesButton;

    /**
     * This method found the name workspace.
     *
     * @return the text of name project.
     */
    public String workSpacesName() {
        return workSpacesName.getText();
    }

    /**
     * This method perform a click on the addProjectsButton WebElement.
     */
    public void clickAddProjectsButton() {
        CommonActions.clickButton(addProjectsButton);
    }

    /**
     * This method perform a click on the projectsDropdown WebElement.
     */
    public void clickProjectsDropdown() {
        CommonActions.clickButton(projectsDropdown);
    }

    /**
     * This method perform a click on selected the project from Dropdown.
     *
     * @param nameProject is the project name.
     */
    public void clickSelectedProjectFromTheDropDown(String nameProject) {
        String selector = String.format("//ul[@data-aid='MenuList']/descendant::span[text()='%s']", nameProject);
        WebElement webElement = webDriver.findElement(By.xpath(selector));
        webElement.click();
    }

    /**
     * This method perform a click on the SaveWorkSpacesButton WebElement.
     */
    public void clickSaveWorkspaceChangesButton() {

        CommonActions.clickButton(saveWorkspaceChangesButton);
    }

    /**
     * Is Project visible.
     *
     * @param nameProject is the project name.
     * @return if the element is found.
     */
    public boolean isProjectVisible(String nameProject) {
        String selector = String.format("//section[@class='projects']/descendant::"
                + "span[@class='full' and text()='%s']", nameProject);
        WebElement webElement = webDriver.findElement(By.xpath(selector));
        return webElement != null;
    }

}
