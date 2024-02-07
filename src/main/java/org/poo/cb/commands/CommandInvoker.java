package org.poo.cb.commands;

import org.poo.cb.App;
import org.poo.cb.exceptions.AppException;

public class CommandInvoker {
    private static CommandInvoker commandInvoker;
    private CommandInvoker() {};
    public static CommandInvoker getInstance() {
        if (commandInvoker == null) {
            commandInvoker = new CommandInvoker();
        }
        return commandInvoker;
    }
    public void executeCommand() throws AppException {
        switch (App.currentCommandSplit[0]) {
            case "CREATE": {
                if (App.currentCommandSplit[1].equals("USER")) {
                    new CreateUserCommand().execute();
                }
                break;
            }
            case "ADD" : {
                if (App.currentCommandSplit[1].equals("FRIEND")) {
                    new AddFriendCommand().execute();
                }
                if (App.currentCommandSplit[1].equals("ACCOUNT")) {
                    new AddAccountCommand().execute();
                }
                if (App.currentCommandSplit[1].equals("MONEY")) {
                    new AddMoneyCommand().execute();
                }
                break;
            }
            case "EXCHANGE" : {
                new ExchangeMoneyCommand().execute();
                break;
            }
            case "TRANSFER" : {
                new TransferMoneyCommand().execute();
                break;
            }
            case "LIST" : {
                if (App.currentCommandSplit[1].equals("USER")) {
                    new ListUserCommand().execute();
                }
                if (App.currentCommandSplit[1].equals("PORTFOLIO")) {
                    new ListPortfolioCommand().execute();
                }
                break;
            }
            case "RECOMMEND" : {
                new RecommendStocksCommand().execute();
                break;
            }
        }
    }
}
