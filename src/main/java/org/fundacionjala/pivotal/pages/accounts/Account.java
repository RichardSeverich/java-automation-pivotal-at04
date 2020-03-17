package org.fundacionjala.pivotal.pages.accounts;

import org.openqa.selenium.By;

import org.fundacionjala.pivotal.pages.base.BasePage;

/**
 * Created by pivotal-test Team.
 */
public class Account extends BasePage {

    /**
     * This method perform a click on the Manage Account of a specified Account.
     *
     * @param name is the name of the account.
     * @return a Account Management page object instance.
     */
    private AccountManagement clickManageAccount(String name) {
        String path = String.format("//div[text()='%s']/ancestor::h3/following::a[contains(@id,'manage')]", name);
        webDriver.findElement(By.xpath(path)).click();
        return new AccountManagement();
    }

    /**
     * This method perform the actions for delete an account.
     *
     * @param name the name of the account to be deleted.
     */
    public void deleteAccount(String name) {
        clickManageAccount(name)
                .clickSettingsButton()
                .deleteAccount();
    }
}
