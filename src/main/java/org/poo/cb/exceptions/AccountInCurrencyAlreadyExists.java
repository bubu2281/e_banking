package org.poo.cb.exceptions;

import org.poo.cb.exceptions.AppException;

public class AccountInCurrencyAlreadyExists extends AppException {
    public AccountInCurrencyAlreadyExists(String currency) {
        super("Account in currency " + currency + " already exists for user");
    }
}
