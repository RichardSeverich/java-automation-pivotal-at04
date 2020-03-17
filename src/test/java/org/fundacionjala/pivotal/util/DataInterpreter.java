package org.fundacionjala.pivotal.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class containing Data Interpreter.
 */
public final class DataInterpreter {

    private static final String SLASH = "/";
    private static final String REGEX_BRACKETS = "(?=\\[)(.*?)(?<=])";
    private static final String REGEX_BRACKETS_INSIDE = "(?<=\\[)(.*?)(?=])";

    /**
     * Private constructor for the Data Builder utility class.
     */
    private DataInterpreter() {

    }

    /**
     * This method return the value of a key stored in the Shared Variables List.
     * Receives a String where the key and value are enclosed in brackets "[key.value]".
     *
     * @param text is the String parameter to process.
     * @return the key value.
     */
    public static Object getValue(String text) {
        Pattern pattern = Pattern.compile(REGEX_BRACKETS_INSIDE);
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            String[] keys = matcher.group(1).split("\\.");
            return keys.length > 1 ? SharedVariableList.findAttribute(keys[0], keys[1]) : "";
        }
        return text;
    }

    /**
     * This method built a end point based in a string line parameter.
     * Replaces the key and value identifiers enclosed in brackets with the corresponding value.
     *
     * @param line the original string line parameter.
     * @return the built end point.
     */
    public static String builtEndPoint(String line) {
        String[] parts = line.split(SLASH);
        for (int i = 0; i < parts.length; i++) {
            parts[i] = getValue(parts[i]).toString();
        }
        return String.join(SLASH, parts);
    }

    /**
     * This method return a rebuilt message.
     * Replaces the key and value identifiers enclosed in brackets with the corresponding value.
     * E.g: "The name is [Project1.name]" -> "The name is Automated".
     *
     * @param message the original message parameter.
     * @return the rebuilt message.
     */
    public static String rebuiltMessage(String message) {
        return message.replaceAll(REGEX_BRACKETS, getValue(message).toString());
    }
}
