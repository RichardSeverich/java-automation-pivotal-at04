package org.fundacionjala.pivotal.core.browser;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

/**
 * Created by pivotal-test Team.
 */
public final class DriverFactory {


    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(DriverType driverType) {
        Map<DriverType, Browser> map = new EnumMap<>(DriverType.class);
        map.put(DriverType.CHROME, new ChromeBrowser());
        map.put(DriverType.FIREFOX, new FirefoxBrowser());
        map.put(DriverType.DOCKER_CHROME, new DockerChromeBrowser());
        map.put(DriverType.DOCKER_FIREFOX, new DockerFirefoxBrowser());
        map.put(DriverType.BROWSERSTACK, new BrowserStack());
        map.put(DriverType.SAUCELABS, new SauceLabs());
        return map.get(driverType).getBrowser();
    }
}
