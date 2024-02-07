package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserDoesNotExist;

public class ListUserCommand extends Command{
    @Override
    protected void execute() throws UserDoesNotExist {
        String email = App.currentCommandSplit[2];
        if (!App.users.containsKey(email)) {
            throw new UserDoesNotExist(email);
        }
        User user = App.users.get(email);
        user.listUser();
    }
}
