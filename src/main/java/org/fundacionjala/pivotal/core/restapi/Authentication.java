package org.fundacionjala.pivotal.core.restapi;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import org.fundacionjala.pivotal.core.util.Environment;

/**
 * Created by pivotal-test Team.
 */
public final class Authentication {

    private static final String BASE_URL_API = "https://www.pivotaltracker.com/services/v5";

    private static final String X_TRACKER_TOKEN_HEADER = "X-TrackerToken";

    private static Authentication singleton;

    private RequestSpecification requestSpecification;

    /**
     * This is the constructor for que Authentication singleton class.
     */
    private Authentication() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL_API)
                .addHeader(X_TRACKER_TOKEN_HEADER,  Environment.getInstance().getToken())
                .build();
    }

    /**
     * This method instantiate the singleton object of the Authentication class.
     *
     * @return the singleton instance.
     */
    public static Authentication getSingleton() {
        if (singleton == null) {
            singleton = new Authentication();
        }
        return singleton;
    }

    /**
     * This method return the Request Specification instance.
     *
     * @return the Request Specification instance.
     */
    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
