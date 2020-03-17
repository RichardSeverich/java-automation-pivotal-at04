package org.fundacionjala.pivotal.pages.base;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Abstract class that gets common info in Settings Page.
 */
public class BaseSettingsForm extends BasePage {
    @FindBy(className = "save_bar__submit")
    private WebElement saveButton;

    @FindBy(id = "delete_link")
    private WebElement deleteLink;

    @FindBy(id = "confirm_delete")
    private WebElement confirmDeleteButton;

    /**
     * This method perform a click on the Save Changes button.
     */
    public void clickSaveButton() {
        CommonActions.clickButton(saveButton);
    }

    /**
     * This method perform a click on the Delete Link.
     */
    public void clickDeleteLink() {
        CommonActions.clickButton(deleteLink);
    }

    /**
     * This method perform a click on the Confirm Delete button.
     */
    public void clickConfirmDeleteButton() {
        CommonActions.clickButton(confirmDeleteButton);
    }
}
