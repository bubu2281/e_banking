package org.poo.cb.exceptions;

import org.poo.cb.User;

public class UserDoesNotExist extends AppException{
    public UserDoesNotExist(String email) {
        super("User with " + email + " doesn't exist");
    }
}
