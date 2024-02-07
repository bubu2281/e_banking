package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.InsufficientAmountPremium;
import org.poo.cb.exceptions.UserDoesNotExist;

public class BuyPremiumCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        if (!App.users.containsKey(email)) {
            throw new UserDoesNotExist(email);
        }
        if (100 > App.users.get(email).getAccounts().get("USD").getAmount()) {
            throw new InsufficientAmountPremium();
        }
        User user = App.users.get(email);
        user.buyPremium();
    }
}
