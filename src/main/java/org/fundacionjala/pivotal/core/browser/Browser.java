package org.fundacionjala.pivotal.core.browser;

import org.openqa.selenium.WebDriver;

/**
 * Created by pivotal-test Team.
 */
@FunctionalInterface
public interface Browser {

    /**
     * This method return a Web Driver instance of a specified browser.
     *
     * @return the Web Driver instance.
     */
    WebDriver getBrowser();
}
