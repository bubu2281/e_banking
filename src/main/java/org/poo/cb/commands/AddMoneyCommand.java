package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.exceptions.AppException;

public class AddMoneyCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        String currency = App.currentCommandSplit[3];
        float amount = Float.parseFloat(App.currentCommandSplit[4]);
        App.users.get(email).addMoney(currency, amount);
    }
}
