package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserAlreadyExists;

import java.util.Arrays;

public class CreateUserCommand extends Command {
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        if (App.users.containsKey(email)) {
            throw new UserAlreadyExists(email);
        }
        String firstName = App.currentCommandSplit[3];
        String lastName = App.currentCommandSplit[4];
        String address = String.join(" ", App.currentCommandSplit).split(" ", 6)[5];
        User user = new User(email, lastName, firstName, address);
        App.users.put(email, user);
    }
}
