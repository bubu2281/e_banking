package org.poo.cb.commands;

import org.poo.cb.Account;
import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.InsufficientFundsStocks;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BuyStocksCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        String company = App.currentCommandSplit[3];
        int noOfStocks = Integer.parseInt(App.currentCommandSplit[4]);
        User user = App.users.get(email);
        float pricePerStock = 0;
        Scanner s = null;
        try {
            s = new Scanner(App.stockValuesFile);
        while(s.hasNextLine()) {
            String[] lineSplit = s.nextLine().split(",");
            if (lineSplit[0].equals(company)) {
                pricePerStock = Float.parseFloat(lineSplit[lineSplit.length - 1]);
            }
        }
        } catch (FileNotFoundException ignored) {}
        Account usdAccount = App.users.get(email).getAccounts().get("USD");
        if (pricePerStock * noOfStocks > usdAccount.getAmount()) {
            throw new InsufficientFundsStocks();
        }
        if (App.recommendedStocks.contains(company) && user.isPremium()) {
            pricePerStock = (float) (pricePerStock * 0.95);
        }
        user.buyStocks(noOfStocks, company, pricePerStock);
    }
}
