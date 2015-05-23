package se.thinkcode.selenium;

import se.thinkcode.selenium.actions.convert.Action;
import se.thinkcode.selenium.actions.convert.BuyCurrency;
import se.thinkcode.selenium.actions.convert.Currency;
import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import static spark.SparkBase.stop;

public class Main {
    public static void main(String[] args) {
        port(8080);
        staticFileLocation("/public");
        convert();
        requestNewPassword();
        awaitInitialization();
    }

    public static void shutdown(){
        stop();
    }

    private static void convert() {
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

            return new ModelAndView(map, "convert_result.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void requestNewPassword() {
        post("/requestPassword", (request, response) -> {
            String account = request.queryParams("account");

            Map<String, String> map = new HashMap<>();
            map.put("account", account);

            return new ModelAndView(map, "password_confirmation.mustache");
        }, new MustacheTemplateEngine());
    }
}
