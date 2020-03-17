package org.fundacionjala.pivotal.pages.accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.pivotal.core.util.CommonActions;
import org.fundacionjala.pivotal.pages.base.BasePage;

/**
 * Created by pivotal-test Team.
 */
public class AccountManagement extends BasePage {
    @FindBy(xpath = "//a[contains(@href, 'settings') and @class='button']")
    private WebElement settingsButton;

    /**
     * This method perform a click in the settings button in the Account Management page.
     *
     * @return a Account settings page object instance.
     */
    public AccountSettings clickSettingsButton() {
        CommonActions.clickButton(settingsButton);
        return new AccountSettings();
    }
}
