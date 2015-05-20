package se.thinkcode.selenium;

import se.thinkcode.selenium.actions.BuyCurrency;
import se.thinkcode.selenium.infrastructure.Action;
import se.thinkcode.selenium.model.Currency;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.post;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

public class Main {
    public static void main(String[] args) {
        port(8080);
        staticFileLocation("/public");
        respondToConvert();
    }

    private static void respondToConvert() {
        post("/convert", (request, response) -> {
            String actionStr = request.queryParams("action");
            String toCurrencyStr = request.queryParams("toCurrency");
            String amountStr = request.queryParams("amount");
            String fromCurrencyStr = request.queryParams("fromCurrency");

            Action action = new Action(actionStr);
            int amount = Integer.parseInt(amountStr);
            Currency to = new Currency(toCurrencyStr);
            Currency from = new Currency(fromCurrencyStr);

            BuyCurrency buyCurrency = new BuyCurrency(action, amount, to, from);
            int cost = buyCurrency.getCost();

            Map<String, String> map = new HashMap<>();
            map.put("amount", "" + amountStr);
            map.put("toCurrency", "" + toCurrencyStr);
            map.put("cost", "" + cost);
            map.put("fromCurrency", fromCurrencyStr);

            return new ModelAndView(map, "result.mustache");
        }, new MustacheTemplateEngine());
    }
}
