package org.poo.cb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Portfolio {
    private ArrayList<Stock> stocks;
    private ArrayList<Account> accounts;

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public Portfolio() {
        this.stocks = new ArrayList<>();
        this.accounts = new ArrayList<>();
    }
    public void listPortfolio() {
        ObjectMapper json = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Float.class, new CustomFloatSerializer());
        json.registerModule(module);
        try {
            System.out.println(json.writeValueAsString(this));
        } catch (JsonProcessingException ignored) {
        }
    }
}
