package org.fundacionjala.pivotal.core.browser;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * SauceLabs class that implements IBrowsers.
 */
public class SauceLabs extends CloudBasedBrowser implements Browser {

    private static final String URL = String
            .format("https://%s:%s@ondemand.saucelabs.com:443/wd/hub", USERNAME, ACCESS_KEY);
    private static final String PLATFORM = "platform";
    private static final String RESOLUTION = "resolution";


    /**
     * Constructor.
     */
    public SauceLabs() {
        super(URL);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DesiredCapabilities setCapabilities() {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability(PLATFORM, String.format("%s %s",
                ENV.getRemotePlatform(),
                ENV.getRemotePlatformVersion()));
        caps.setCapability(RESOLUTION, ENV.getRemoteResolution());
        return caps;
    }
}
