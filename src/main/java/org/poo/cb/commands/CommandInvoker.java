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
        new CommandFactory().getCommand().execute();
    }
}
