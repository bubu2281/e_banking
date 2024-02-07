package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.Portfolio;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserDoesNotExist;

public class ListPortfolioCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        if (!App.users.containsKey(email)) {
            throw new UserDoesNotExist(email);
        }
        Portfolio portfolio = App.users.get(email).getPortfolio();
        portfolio.listPortfolio();
    }
}
