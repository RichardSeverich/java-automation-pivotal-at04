package org.fundacionjala.pivotal.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;

/**
 * Created by pivotal-test Team.
 */
public class AccountSettings extends BasePage {

    @FindBy(css = "a[data-method='delete']")
    private WebElement deleteLabel;

    /**
     * This method perform a click on the delete account label.
     */
    private void clickDeleteLabel() {
        CommonActions.clickButton(deleteLabel);
    }

    /**
     * This method perform a click on the accept option in the alert confirmation message.
     */
    private void acceptAlertMessage() {
        webDriver.switchTo().alert().accept();
    }

    /**
     * This method perform the actions to delete the account.
     *
     * @return a Account page object instance.
     */
    public Account deleteAccount() {
        clickDeleteLabel();
        acceptAlertMessage();
        return new Account();
    }
}
