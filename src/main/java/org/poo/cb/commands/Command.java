package org.poo.cb.commands;

import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserAlreadyExists;

public abstract class Command {

    protected abstract void execute() throws AppException;
}
