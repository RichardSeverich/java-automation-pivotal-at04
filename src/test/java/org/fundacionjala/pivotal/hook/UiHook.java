package org.fundacionjala.pivotal.hook;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.core.util.Navigator;
import org.fundacionjala.pivotal.util.Helper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

/**
 * Created by pivotal-test Team.
 */
public class UiHook {

    private Helper helper;

    /**
     * Api Hook constructor using Dependency Injection.
     *
     * @param helper object utility instance.
     */
    public UiHook(Helper helper) {
        this.helper = helper;
    }

    /**
     * Hook for delete the created account for the UI tests.
     */
    @After("@DeleteAccount")
    public void deleteAccount() {
        Navigator.loadDashboardPage().clickAccountListItem().deleteAccount(helper.getAccountVariable());
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png"); //stick it in the report
        }
    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before("@SoftAssert")
    public void setSoftAssert() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * The before hook carry default order of 10000.
     * This before was changes for the order 1000.
     * This method cleans the helper.
     */
    @Before(order = 1000)
    public void setHardAssert() {
        helper.setAssertion(new Assertion());
    }
}
