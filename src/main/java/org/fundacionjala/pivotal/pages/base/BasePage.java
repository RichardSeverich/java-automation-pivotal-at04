package org.fundacionjala.pivotal.pages.base;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract Class BasePage implementing Page Object pattern.
 */
public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    /**
     * This method is the constructor class.
     */
    public BasePage() {
        webDriver = DriverManager.getInstance().getWebDriver();
        webDriverWait = DriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
    }
}
