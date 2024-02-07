package org.poo.cb.exceptions;

public class InsufficientAmountTransfer extends AppException {
    public InsufficientAmountTransfer(String currency) {
        super("Insufficient amount in account " + currency + " for transfer");
    }
}
