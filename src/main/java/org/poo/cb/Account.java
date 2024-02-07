package org.poo.cb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Account {
    private final User owner;
    private String currencyName;
    private float amount;
    public Account(String currency, User owner) {
        this.currencyName = currency;
        this.amount = 0;
        this.owner = owner;
    }
    @JsonSerialize(using = CustomFloatSerializer.class)
    public float getAmount() {
        return amount;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void addMoney(float amount) {
        this.amount += amount;
    }
    public void exchangeMoney(String destinationCurrency, double amount, double exchangeRate) {
        double initalAmount = amount;
        amount = amount * exchangeRate;

        if (amount > this.amount * 0.5) {
            //comisionul de 1% in caz de depasire a pragului de 50% din contul sursa
            amount = (double) (amount * 1.01);
        }
        this.amount -= (float) amount;
        owner.getAccounts().get(destinationCurrency).addMoney((float) initalAmount);
    }
    public void transferMoney(User receiver, float amount) {
        this.amount -= amount;
        receiver.getAccounts().get(this.currencyName).addMoney(amount);
    }
}
