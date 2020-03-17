package org.fundacionjala.pivotal.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.fundacionjala.pivotal.core.CustomRuntimeException;

/**
 * The Environment class to read data from gradle.properties.
 */
public final class Environment {
    private static final String USERNAME = "username";
    private static final String PASS = "password";
    private static final String TOKEN = "token";
    private static final String BASE_URL = "baseurl";
    private static final String BROWSER = "browser";
    private static final String DOCKER_URL = "dockerUrl";
    private static final String REMOTE_USER_NAME = "remoteUserName";
    private static final String REMOTE_KEY = "remoteKey";
    private static final String REMOTE_BROWSER = "remoteBrowser";
    private static final String REMOTE_BROWSER_VERSION = "remoteBrowserVersion";
    private static final String REMOTE_PLATFORM = "remotePlatform";
    private static final String REMOTE_PLATFORM_VERSION = "remotePlatformVersion";
    private static final String REMOTE_RESOLUTION = "remoteResolution";
    private static final Logger LOGGER = LogManager.getLogger();

    private static Environment instance;
    private Properties envProperties;

    /**
     * This is the constructor for the Environment class.
     */
    private Environment() {
        try (FileInputStream fileInputStream = new FileInputStream("gradle.properties")) {
            envProperties = new Properties();
            envProperties.load(fileInputStream);
        } catch (IOException e) {
            String message = "Not instance driver";
            LOGGER.error(message);
            LOGGER.info(e);
            throw new CustomRuntimeException(message, e);
        }
    }

    /**
     * This method return the singleton instance of the Environment class.
     *
     * @return the singleton instance.
     */
    public static Environment getInstance() {
        if (instance == null) {
            instance = new Environment();
        }
        return instance;
    }

    /**
     * This method return the string for a specific environment property.
     *
     * @param env is the property string.
     * @return the specified property.
     */
    private String getEnv(final String env) {
        String property = System.getProperty(env);
        if (property == null) {
            return envProperties.getProperty(env);
        }
        return property;
    }

    /**
     * This method return the password from the environment properties.
     *
     * @return the password in a string object.
     */
    public String getPassword() {
        return getEnv(PASS);
    }

    /**
     * This method return the user from the environment properties.
     *
     * @return the user in a string object.
     */
    public String getUser() {
        return getEnv(USERNAME);
    }

    /**
     * This method return the restapi token from the environment properties.
     *
     * @return the token in a string object.
     */
    public String getToken() {
        return getEnv(TOKEN);
    }

    /**
     * This method return the base url from the environment properties.
     *
     * @return the base url in a string object.
     */
    public String getBaseUrl() {
        return getEnv(BASE_URL);
    }

    /**
     * This method return the user from the environment properties.
     *
     * @return the getBrowser in a string object.
     */
    public String getBrowser() {
        return getEnv(BROWSER);
    }

    /**
     * This method return the user from the environment properties.
     *
     * @return the getRemoteUserName in a string object.
     */
    public String getRemoteUserName() {
        return getEnv(REMOTE_USER_NAME);
    }

    /**
     * This method return the remoteKey from the environment properties.
     *
     * @return the getRemoteKey in a string object.
     */
    public String getRemoteKey() {
        return getEnv(REMOTE_KEY);
    }

    /**
     * This method return the RemoteBrowser from the environment properties.
     *
     * @return the getRemoteBrowser in a string object.
     */
    public String getRemoteBrowser() {
        return getEnv(REMOTE_BROWSER);
    }

    /**
     * This method return the RemoteBrowserVersion from the environment properties.
     *
     * @return the getRemoteBrowserVersion in a string object.
     */
    public String getRemoteBrowserVersion() {
        return getEnv(REMOTE_BROWSER_VERSION);
    }

    /**
     * This method return the RemotePlatform from the environment properties.
     *
     * @return the getRemotePlatform in a string object.
     */
    public String getRemotePlatform() {
        return getEnv(REMOTE_PLATFORM);
    }

    /**
     * This method return the RemotePlatformVersion from the environment properties.
     *
     * @return the getRemotePlatformVersion in a string object.
     */
    public String getRemotePlatformVersion() {
        return getEnv(REMOTE_PLATFORM_VERSION);
    }

    /**
     * This method return the RemoteResolution from the environment properties.
     *
     * @return the getRemoteResolution in a string object.
     */
    public String getRemoteResolution() {
        return getEnv(REMOTE_RESOLUTION);

    }

    /**
     * This method return the docker url from the environment properties.
     *
     * @return the docker url in a string object.
     */
    public String getDockerUrl() {
        return getEnv(DOCKER_URL);
    }

    /**
     * This method return the implicit time wait from the environment properties.
     *
     * @return the implicit time wait in an int value.
     */
    public int getImplicitTimeWait() {
        return Integer.parseInt(getEnv("implicitTimeWait"));
    }

    /**
     * This method return the explicit time wait from the environment properties.
     *
     * @return the explicit time wait in an int value.
     */
    public int getExplicitTimeWait() {
        return Integer.parseInt(getEnv("explicitTimeWait"));
    }
}
