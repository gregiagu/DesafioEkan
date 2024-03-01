package io.github.gregiagu.ekan.exceptions;

public class RecipientNotFoundException extends RuntimeException {

    public RecipientNotFoundException(String message) {
        super(message);
    }

    public RecipientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipientNotFoundException(Throwable cause) {
        super(cause);
    }
}
