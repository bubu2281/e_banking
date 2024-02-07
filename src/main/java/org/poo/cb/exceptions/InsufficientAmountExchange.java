package org.poo.cb.exceptions;

import org.poo.cb.exceptions.AppException;

import java.util.Currency;

public class InsufficientAmountExchange extends AppException {
    public InsufficientAmountExchange(String sourceCurrency) {
        super("Insufficient amount in account " + sourceCurrency + " for exchange");
    }
}
