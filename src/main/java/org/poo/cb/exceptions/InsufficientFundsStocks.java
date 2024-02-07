package org.poo.cb.exceptions;

public class InsufficientFundsStocks extends AppException{
    public InsufficientFundsStocks() {
        super("Insufficient amount in account for buying stock");
    }
}
