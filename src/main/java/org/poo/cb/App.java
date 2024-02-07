package org.poo.cb;

import org.poo.cb.commands.CommandInvoker;
import org.poo.cb.exceptions.AppException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    private static App app;
    public static File exchangeRatesFile;
    public static File stockValuesFile;
    public static File commandsFile;
    public static HashMap<String,User> users;
    public static String[] currentCommandSplit;
    private App() {};
    public static App getInstance() {
        if (app == null) {
            app = new App();
        }
        return app;
    }
    public void init(String exchangeRatesFile, String stockValuesFile, String commandsFile) {
        App.exchangeRatesFile = new File("src/main/resources/" + exchangeRatesFile);
        App.stockValuesFile = new File ("src/main/resources/" + stockValuesFile);
        App.commandsFile = new File("src/main/resources/" + commandsFile);
        users = new HashMap<>();
    }

//    public static void resetApp() {
//        users = new HashMap<>();
//    }
    public void run() {
        try {
            Scanner s = new Scanner(commandsFile);
            while (s.hasNextLine()) {
                currentCommandSplit = s.nextLine().split(" ");
                try {
                    CommandInvoker.getInstance().executeCommand();
                } catch (AppException appE) {
                    System.out.println(appE.getMessage());
                }
            }
        } catch (FileNotFoundException ignored) {

        }
    }
}
