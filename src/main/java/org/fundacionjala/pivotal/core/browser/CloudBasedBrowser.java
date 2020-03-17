package org.fundacionjala.pivotal.core.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.pivotal.core.CustomRuntimeException;
import org.fundacionjala.pivotal.core.util.Environment;

/**
 * Abstract class for Cloud Based Browsers.
 */
public abstract class CloudBasedBrowser implements Browser {

    protected static final Environment ENV = Environment.getInstance();
    protected static final String USERNAME = ENV.getRemoteUserName();
    protected static final String ACCESS_KEY = ENV.getRemoteKey();
    private static final Logger LOGGER = LogManager.getLogger();

    private String url;

    /**
     * This is the constructor.
     *
     * @param url This variable contains the url authentication.
     */
    public CloudBasedBrowser(String url) {
        this.url = url;
    }

    /**
     * This method save all capabilities.
     *
     * @return setting capabilities SauceLabs.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            String message = "URL malformed";
            LOGGER.error(message);
            LOGGER.info(e);
            throw new CustomRuntimeException(message, e);
        }
        return driver;
    }
}
