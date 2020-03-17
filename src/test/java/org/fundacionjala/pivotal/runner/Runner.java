package org.fundacionjala.pivotal.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.fundacionjala.pivotal.core.browser.DriverManager;
import org.fundacionjala.pivotal.core.util.Environment;
import org.fundacionjala.pivotal.pages.signin.SignIn;

/**
 * Created by pivotal-test Team.
 */
@CucumberOptions(
        monochrome = true,
        format = {"pretty",
                "html:target/test-report",
                "json:target/test-report.json",
                "junit:target/test-report.xml"},
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.pivotal"})
public class Runner extends AbstractTestNGCucumberTests {

    /**
     * This method perform the smart login process.
     */
    @BeforeTest
    public void login() {
        SignIn.signInAs(Environment.getInstance().getUser(), Environment.getInstance().getPassword());
    }

    /**
     * This method close the web driver after the all feature test execution.
     */
    @AfterTest
    public void closeBrowser() {
        DriverManager.getInstance().getWebDriver().quit();
    }
}
