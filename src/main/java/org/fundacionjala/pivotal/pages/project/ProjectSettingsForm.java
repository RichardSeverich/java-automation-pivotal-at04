package org.fundacionjala.pivotal.pages.project;

import org.fundacionjala.pivotal.pages.base.BasePage;
import org.fundacionjala.pivotal.pages.dashboard.Dashboard;
import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Project Settings Page.
 */
public class ProjectSettingsForm extends BasePage {

    @FindBy(id = "delete_link")
    private WebElement deleteLabel;

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteButton;

    @FindBy(css = "div[id=save_success_bar] > div")
    private WebElement changesSuccessLabel;

    @FindBy(id = "project_name")
    private WebElement projectNameInputField;

    @FindBy(className = "save_bar__submit")
    private WebElement saveButton;

    @FindBy(className = "error_above_or_below")
    private WebElement errorMessage;

    /**
     * This method perform a click on the Delete label WebElement.
     */
    private void clickDeleteLabel() {
        CommonActions.jsClickElement(deleteLabel);
    }

    /**
     * This method perform a click on the Confirm Delete button.
     */
    private void clickConfirmDeleteButton() {
        CommonActions.clickButton(confirmDeleteButton);
    }

    /**
     * This method perform a click on the Save Changes button.
     */
    public void clickSaveButton() {
        CommonActions.jsClickElement(saveButton);
    }

    /**
     * This method sets the Project Name input field content with the parameter value.
     *
     * @param name is the project name new value.
     */
    private void setProjectNameInputField(String name) {
        CommonActions.setInputField(projectNameInputField, name);
    }

    /**
     * This method return the text value of the Changes Success label.
     *
     * @return the text content.
     */
    public String getChangesSuccessText() {
        return CommonActions.getTextContent(changesSuccessLabel);
    }

    /**
     * This method perform the actions to delete a project in the Project Settings page.
     *
     * @return a Dashboard page object.
     */
    public Dashboard deleteProject() {
        clickDeleteLabel();
        clickConfirmDeleteButton();
        return new Dashboard();
    }

    /**
     * This method perform the modification action for a Project name.
     *
     * @param name is the new Project name.
     */
    public void modifyProjectName(String name) {
        setProjectNameInputField(name);
        clickSaveButton();
    }

    /**
     * Check if exists an error message for the Project Name.
     *
     * @return if the error is visible.
     */
    public boolean isErrorMessageDisplayed() {
        return CommonActions.isVisible(errorMessage);
    }
}
