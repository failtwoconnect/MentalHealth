package com.failtwoconnect.springbootmentalhealthv2.exceptions;

public class SaveFailedException extends Exception {

    public SaveFailedException(String message) {
        super(message);
    }

    public SaveFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveFailedException(Throwable cause) {
        super(cause);
    }

    public SaveFailedException() {
        super();
    }

}
