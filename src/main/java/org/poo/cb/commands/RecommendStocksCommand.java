package org.poo.cb.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.poo.cb.App;
import org.poo.cb.exceptions.AppException;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RecommendStocksCommand extends Command{
    @Override
    protected void execute() throws AppException {
        Scanner s = null;
        RecommendedStocks recommendations = new RecommendedStocks();
        try {
            s = new Scanner(App.stockValuesFile);
            s.nextLine();
            while(s.hasNextLine()) {
                String[] lineSplit = s.nextLine().split(",");
                double shortAverage = 0;
                double longAverage = 0;
                for (int i = 1; i <= 10; i++) {
                    if (i > 5) {
                        shortAverage += Double.parseDouble(lineSplit[i]);
                    }
                    longAverage += Double.parseDouble(lineSplit[i]);
                }
                shortAverage /= 5;
                longAverage /= 10;
                if (shortAverage > longAverage) {
                    recommendations.addStockToBuy(lineSplit[0]);
                }
            }
        } catch (FileNotFoundException ignored) {
        }
        ObjectMapper json = new ObjectMapper();
        try {
            System.out.println(json.writeValueAsString(recommendations));
        } catch (JsonProcessingException ignored) {
        }
    }
}
