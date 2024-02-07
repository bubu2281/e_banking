package org.poo.cb.exceptions;

public class NotAllowedToTransfer extends AppException {
    public NotAllowedToTransfer(String emailFriend) {
        super("You are not allowed to transfer money to " + emailFriend);
    }
}
