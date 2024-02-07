package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AccountInCurrencyAlreadyExists;
import org.poo.cb.exceptions.AppException;

public class AddAccountCommand extends Command {
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        String currency = App.currentCommandSplit[3];
        User user = App.users.get(email);
        if (user.getAccounts().containsKey(currency)) {
            throw new AccountInCurrencyAlreadyExists(currency);
        }
        user.addAccount(currency);
    }
}
