package org.poo.cb.exceptions;

public class InsufficientAmountPremium extends AppException{
    public InsufficientAmountPremium() {
        super("Insufficient amount in account for buying premium option");
    }
}
