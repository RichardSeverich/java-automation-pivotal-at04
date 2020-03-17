package org.fundacionjala.pivotal.core.restapi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Created by pivotal-test Team.
 */
public final class RequestManager {

    private static final RequestSpecification REQUEST = Authentication.getSingleton().getRequestSpecification();

    /**
     * Private constructor for the Request Manager utility class.
     */
    private RequestManager() {

    }

    /**
     * This method perform a GET request based in a end point parameter.
     *
     * @param endpoint the specified end point.
     * @return a response object.
     */
    public static Response get(String endpoint) {
        return given()
                .spec(REQUEST)
                .when()
                .get(endpoint);
    }

    /**
     * This method perform a POST request based in a end point and body parameters.
     *
     * @param endpoint is the specified end point.
     * @param body     is the body content.
     * @return a response object.
     */
    public static Response post(String endpoint, String body) {
        return given()
                .spec(REQUEST)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .post(endpoint);
    }

    /**
     * This method perform a POST request based in a end point and body map parameters.
     *
     * @param endpoint is the specified end point.
     * @param body     is the map body content.
     * @return a response object.
     */
    public static Response post(String endpoint, Map<String, String> body) {
        return given()
                .spec(REQUEST)
                .params(body)
                .when()
                .post(endpoint);
    }

    /**
     * This method perform a PUT request based in a end point and body parameters.
     *
     * @param endpoint is the specified end point.
     * @param body     is the body content.
     * @return is the body content.
     */
    public static Response put(String endpoint, String body) {
        return given()
                .spec(REQUEST)
                .contentType(ContentType.JSON)
                .when()
                .body(body)
                .put(endpoint);
    }

    /**
     * This method perform a PUT request based in a end point and body map parameters.
     *
     * @param endpoint is the specified end point.
     * @param body     is the map body content.
     * @return a response object.
     */
    public static Response put(String endpoint, Map<String, String> body) {
        return given()
                .spec(REQUEST)
                .params(body)
                .when()
                .put(endpoint);
    }

    /**
     * This method perform a DELETE request based in a end point parameter.
     *
     * @param endpoint is the specified end point.
     * @return is the body content.
     */
    public static Response delete(String endpoint) {
        return given()
                .spec(REQUEST)
                .when()
                .delete(endpoint);
    }
}
