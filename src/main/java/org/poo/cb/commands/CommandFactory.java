package org.poo.cb.commands;

import org.poo.cb.App;

public class CommandFactory {
    public Command getCommand() {
        switch (App.currentCommandSplit[0]) {
            case "CREATE": {
                if (App.currentCommandSplit[1].equals("USER")) {
                    return new CreateUserCommand();
                }
            }
            case "ADD" : {
                if (App.currentCommandSplit[1].equals("FRIEND")) {
                    return new AddFriendCommand();
                }
                if (App.currentCommandSplit[1].equals("ACCOUNT")) {
                    return new AddAccountCommand();
                }
                if (App.currentCommandSplit[1].equals("MONEY")) {
                    return new AddMoneyCommand();
                }
            }
            case "EXCHANGE" : {
                return new ExchangeMoneyCommand();
            }
            case "TRANSFER" : {
                return new TransferMoneyCommand();
            }
            case "LIST" : {
                if (App.currentCommandSplit[1].equals("USER")) {
                    return new ListUserCommand();
                }
                if (App.currentCommandSplit[1].equals("PORTFOLIO")) {
                    return new ListPortfolioCommand();
                }
            }
            case "RECOMMEND" : {
                return new RecommendStocksCommand();
            }
            case "BUY" : {
                if (App.currentCommandSplit[1].equals("STOCKS")) {
                    return new BuyStocksCommand();
                }
                if (App.currentCommandSplit[1].equals("PREMIUM")) {
                    return new BuyPremiumCommand();
                }
            }
        }
        return new DoNothingCommand();
    }
}
