package pl.sdacademy.prog;

import pl.sdacademy.prog.zad2.CurrencyData;
import pl.sdacademy.prog.zad2.CurrencyDataService;
import pl.sdacademy.prog.zad2.CurrencyDataWriter;
import pl.sdacademy.prog.zad2.CurrencyStaticsProvider;

import java.io.IOException;
import java.util.List;
import java.util.function.BiConsumer;

public class CurrencyPracticeMain {
    public static void main(String[] args) throws IOException {
        final String inputFile = args[0];
        final String outputFile = args[1];

        final CurrencyDataService currencyDataService = new CurrencyDataService();
        final CurrencyStaticsProvider currencyStatisticsProvider = new CurrencyStaticsProvider();

        final List<CurrencyData> currencyData = currencyDataService.processDataFromFile(inputFile);
//        final CurrencyDataWriter currencyDataWriter = new CurrencyDataWriter();
//        CurrencyDataWriter.saveToFile(outputFile, currencyData);
        currencyStatisticsProvider.getCountriesWithOwnCurrency(currencyData).forEach(System.out::println);
        currencyStatisticsProvider.getCurrencyToNumberOfCountriesUsingIt(currencyData).forEach((k, v) -> System.out.println(k + " " + v));


    }

}
