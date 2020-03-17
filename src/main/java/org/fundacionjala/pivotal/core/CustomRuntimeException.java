package org.fundacionjala.pivotal.core;

/**
 * Custom Runtime Exception class.
 */
public class CustomRuntimeException extends RuntimeException {

    /**
     * Constructor for Exception class.
     * @param message Custom message for the error.
     * @param cause The cause for the error was thrown.
     */
    public CustomRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }
}
