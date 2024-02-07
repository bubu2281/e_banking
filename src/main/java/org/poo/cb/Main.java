package org.poo.cb;

import org.poo.cb.exceptions.AppException;
import org.poo.cb.exceptions.UserAlreadyExists;

public class Main {
    public static void main(String[] args) {
        if(args == null) {
            System.out.println("Running Main");
            return;
        }
        if (args.length == 3) {
            App app = App.getInstance();
            app.init(args[0], args[1], args[2]);
            app.run();
        }
    }
}