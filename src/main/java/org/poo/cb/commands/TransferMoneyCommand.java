package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.InsufficientAmountTransfer;
import org.poo.cb.exceptions.NotAllowedToTransfer;

public class TransferMoneyCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        String friendEmail = App.currentCommandSplit[3];
        String currency = App.currentCommandSplit[4];
        float amount = Float.parseFloat(App.currentCommandSplit[5]);
        User user = App.users.get(email);
        User friend = App.users.get(friendEmail);
        if (amount > user.getAccounts().get(currency).getAmount()) {
            throw new InsufficientAmountTransfer(currency);
        }
        if (!user.getFriends().contains(friendEmail)) {
            throw new NotAllowedToTransfer(friendEmail);
        }
        user.getAccounts().get(currency).transferMoney(friend, amount);
    }
}
