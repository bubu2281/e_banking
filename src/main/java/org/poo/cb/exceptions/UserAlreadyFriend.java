package org.poo.cb.exceptions;

public class UserAlreadyFriend extends AppException{
    public UserAlreadyFriend(String email) {
        super("User with " + email + " is already a friend");
    }
}
