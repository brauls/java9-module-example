package de.brauls.example.j9modex.usermanagement.exception;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(final String message) {
        super(message);
    }
}
