package org.fundacionjala.pivotal.pages.base;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Abstract class that gets common info in Form Page.
 */
public class BaseForm extends BasePage {
    @FindBy(className = "tc-form__input")
    private WebElement nameInputField;

    @FindBy(xpath = "//button[@data-aid='FormModal__submit']")
    private WebElement createButton;

    /**
     * Clicks the Create Button of the Form.
     */
    public void clickCreateButton() {
        CommonActions.clickButton(createButton);
    }

    /**
     * This method sets the name  in the Form name input field.
     *
     * @param name is the new Form name.
     */
    public void setNameInputField(String name) {
        CommonActions.setInputField(nameInputField, name);
    }
}
