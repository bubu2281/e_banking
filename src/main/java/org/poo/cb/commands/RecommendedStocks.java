package org.poo.cb.commands;

import java.util.ArrayList;

public class RecommendedStocks {
    ArrayList<String> stocksToBuy;

    public ArrayList<String> getStocksToBuy() {
        return stocksToBuy;
    }

    RecommendedStocks() {
        this.stocksToBuy = new ArrayList<>();
    }
    public void addStockToBuy(String stock) {
        this.stocksToBuy.add(stock);
    }
}
