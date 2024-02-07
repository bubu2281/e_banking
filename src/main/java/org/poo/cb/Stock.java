package org.poo.cb;

public class Stock {
    private String stockName;
    private int amount;
    public Stock(String companyName, int noOfStocks) {
        this.stockName = companyName;
        this.amount = noOfStocks;
    }

    public String getStockName() {
        return stockName;
    }

    public int getAmount() {
        return amount;
    }
}
