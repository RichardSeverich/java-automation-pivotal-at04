package org.fundacionjala.pivotal.pages.workspace;


import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BaseForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class contains Workspaces Create Form Page.
 */
public class WorkspacesCreateForm extends BaseForm {

    @FindBy(css = "div.tc-form-modal__section > div.tc-form__input--error-message")
    private WebElement errorMessage;

    @FindBy(css = "div.tc-form__input--error-message span")
    private WebElement emptyErrorMessage;

    /**
     * This method return the text of message de error when a name workspace already exist.
     *
     * @return the text of message error.
     */
    public String errorMessageWhenNameAlreadyExist() {
        return CommonActions.getTextContent(errorMessage);
    }

    /**
     * This method return the text of message de error when a name workspace is empty.
     *
     * @return the text of message error.
     */
    public String errorMessageWhenNameIsEmpty() {
        return CommonActions.getTextContent(emptyErrorMessage);
    }
}
