package org.poo.cb.exceptions;

public class UserAlreadyExists extends AppException {
    public UserAlreadyExists(String email) {
        super("User with " + email + " already exists");
    }
}
