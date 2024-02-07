package org.poo.cb.commands;

import org.poo.cb.Account;
import org.poo.cb.App;
import org.poo.cb.User;
import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.InsufficientAmountExchange;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExchangeMoneyCommand extends Command{
    @Override
    protected void execute() throws AppException {
        String email = App.currentCommandSplit[2];
        String sourceCurrency = App.currentCommandSplit[3];
        String destinationCurrency = App.currentCommandSplit[4];
        User user = App.users.get(email);
        float amount = Float.parseFloat(App.currentCommandSplit[5]);
        double exchangeRate = 0;
        int indexSource = 0;
        try {
            Scanner s = new Scanner(App.exchangeRatesFile);
            while (s.hasNextLine()) {
                String[] lineSplit = s.nextLine().split(",");
                if (lineSplit[0].equals(sourceCurrency)) {
                    break;
                }
                indexSource++;
            }
        } catch (FileNotFoundException e) {
            return;
        }
        try {
            Scanner s = new Scanner(App.exchangeRatesFile);
            while (s.hasNextLine()) {
                String[] lineSplit = s.nextLine().split(",");
                if (lineSplit[0].equals(destinationCurrency)) {
                    exchangeRate = Float.parseFloat(lineSplit[indexSource]);
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            return;
        }
        if (amount * exchangeRate > user.getAccounts().get(sourceCurrency).getAmount()) {
            throw new InsufficientAmountExchange(sourceCurrency);
        }
        Account sourceAccount = user.getAccounts().get(sourceCurrency);
        sourceAccount.exchangeMoney(destinationCurrency, amount, exchangeRate);
    }
}
