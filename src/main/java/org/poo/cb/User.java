package org.poo.cb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.HashSet;


public class User {
    private final String email;
    private String firstName;
    private String lastName;
    private String address;
    private final HashSet<String> friends;
    private HashMap<String, Account> accounts;
    private Portfolio portfolio;

    public User(String email, String lastName, String firstName, String address) {
        this.email = email;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.friends = new HashSet<>();
        this.accounts = new HashMap<>();
        this.portfolio = new Portfolio();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public HashSet<String> getFriends() {
        return friends;
    }
    @JsonIgnore
    public Portfolio getPortfolio() {
        return portfolio;
    }

    @JsonIgnore
    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void addFriend(User user) {
        this.friends.add(user.getEmail());
        user.getFriends().add(this.getEmail());
    }
    public void addAccount(String currency) {
        Account newAccount = new Account(currency, this);
        this.accounts.put(currency, newAccount);
        this.portfolio.getAccounts().add(newAccount);

    }
    public void addMoney(String currency, float amount) {
        this.accounts.get(currency).addMoney(amount);
    }
    public void listUser()   {
        ObjectMapper json = new ObjectMapper();
        try {
            System.out.println(json.writeValueAsString(this));
        } catch (JsonProcessingException ignored) {
        }
    }
    public void buyStocks(int noOfStocks, String company, float pricePerStock) {
        this.accounts.get("USD").removeMoney(noOfStocks * pricePerStock);
        this.portfolio.getStocks().add(new Stock(company, noOfStocks));
    }
}
