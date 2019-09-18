package io.boboo.api.client.exception;

import io.boboo.api.client.BobooApiError;

/**
 * An exception which can occur while invoking methods of the BOBOO API.
 */
public class BobooApiException extends RuntimeException {

    private static final long serialVersionUID = 3788669840036201041L;
    /**
     * Error response object returned by BOBOO API.
     */
    private BobooApiError error;

    /**
     * Instantiates a new BOBOO api exception.
     *
     * @param error an error response object
     */
    public BobooApiException(BobooApiError error) {
        this.error = error;
    }

    /**
     * Instantiates a new BOBOO api exception.
     */
    public BobooApiException() {
        super();
    }

    /**
     * Instantiates a new BOBOO api exception.
     *
     * @param message the message
     */
    public BobooApiException(String message) {
        super(message);
    }

    /**
     * Instantiates a new BOBOO api exception.
     *
     * @param cause the cause
     */
    public BobooApiException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates a new BOBOO api exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public BobooApiException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @return the response error object from BOBOO API, or null if no response object was returned (e.g. server returned 500).
     */
    public BobooApiError getError() {
        return error;
    }

    @Override
    public String getMessage() {
        if (error != null) {
            return error.getMsg();
        }
        return super.getMessage();
    }
}
