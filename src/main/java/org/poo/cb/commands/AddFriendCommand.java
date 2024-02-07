package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserAlreadyFriend;
import org.poo.cb.exceptions.UserDoesNotExist;

public class AddFriendCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String emailUser = App.currentCommandSplit[2];
        String emailFriend = App.currentCommandSplit[3];
        if (!App.users.containsKey(emailUser)) {
            throw new UserDoesNotExist(emailUser);
        }
        if (!App.users.containsKey(emailFriend)) {
            throw new UserDoesNotExist(emailFriend);
        }
        User user = App.users.get(emailUser);
        User friend = App.users.get(emailFriend);
        if (user.getFriends().contains(friend.getEmail())) {
            throw new UserAlreadyFriend(emailFriend);
        }
        user.addFriend(friend);
    }
}
