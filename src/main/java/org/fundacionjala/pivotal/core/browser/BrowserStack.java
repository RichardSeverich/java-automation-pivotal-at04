package org.fundacionjala.pivotal.core.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * BrowserStack class that implements IBrowsers.
 */
public class BrowserStack extends CloudBasedBrowser implements Browser {

    private static final String URL = String
            .format("https://%s:%s@hub-cloud.browserstack.com/wd/hub", USERNAME, ACCESS_KEY);
    private static final String BROWSER = "browser";
    private static final String VERSION = "browser_version";
    private static final String OS = "os";
    private static final String OS_VERSION = "os_version";
    private static final String RESOLUTION = "resolution";

    /**
     * Constructor.
     */
    public BrowserStack() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(BROWSER, ENV.getRemoteBrowser());
        caps.setCapability(VERSION, ENV.getRemoteBrowserVersion());
        caps.setCapability(OS, ENV.getRemotePlatform());
        caps.setCapability(OS_VERSION, ENV.getRemotePlatformVersion());
        caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
        return caps;
    }
}
