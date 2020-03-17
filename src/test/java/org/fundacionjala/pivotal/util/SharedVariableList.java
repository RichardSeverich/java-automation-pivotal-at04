package org.fundacionjala.pivotal.util;

import java.util.ArrayList;
import java.util.List;

import io.restassured.response.Response;

/**
 * Class containing Shared VariableList.
 */
public final class SharedVariableList {

    private static List<SharedVariable> shareVariablesList = new ArrayList<>();

    /**
     * Private constructor for the shared variable utility class.
     */
    private SharedVariableList() {

    }

    /**
     * This method add a Shared Variable type element to the list.
     *
     * @param sharedVariable is the shared Variable object.
     */
    private static void addSharedVariable(SharedVariable sharedVariable) {
        shareVariablesList.add(sharedVariable);
    }

    /**
     * This method add a new variable to the list.
     *
     * @param name     is the name of the variable.
     * @param response is the response body.
     */
    public static void addVariable(String name, Response response) {
        addSharedVariable(new SharedVariable(name, response.jsonPath().get("")));
    }

    /**
     * This method find an attribute value for a specific variable name.
     *
     * @param variableName is the variable name.
     * @param attribute    is the specified attribute.
     * @return the string representation of the attribute.
     */
    public static String findAttribute(String variableName, String attribute) {
        return shareVariablesList.stream()
                .filter(shareVariableItem -> variableName.equalsIgnoreCase(shareVariableItem.getName()))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Null value."))
                .getAttributeValue(attribute);
    }

    /**
     * This method clean the list.
     */
    public static void cleanList() {
        shareVariablesList.clear();
    }

    /**
     * This method return the list.
     *
     * @return the share variable list.
     */
    public static List<SharedVariable> getList() {
        return shareVariablesList;
    }
}
