package se.thinkcode.selenium;

import se.thinkcode.selenium.actions.buy.currency.Action;
import se.thinkcode.selenium.actions.buy.currency.BuyCurrency;
import spark.ModelAndView;
import spark.QueryParamsMap;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {
        int port = getPort();
        port(port);
        staticFileLocation("/public");
        index();
        helloWorld();
        requestPassword();
        selectColor();
        selectedColor();
        selectBeverage();
        selectCondiment();
        alert();
        requestNewPassword();
        exchangeRate();
        newPopupPage();
        buyCurrency();
        calculateCurrencyCost();
        about();
        awaitInitialization();
    }

    private static int getPort() {
        String port = System.getProperty("port", "8080");
        return Integer.parseInt(port);
    }

    public static void shutdown() {
        stop();
    }

    private static void index() {
        get("/", (request, response) -> {
            return new ModelAndView(null, "index.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void helloWorld() {
        get("/helloWorld", (request, response) -> {
            return new ModelAndView(null, "hello_world.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void requestPassword() {
        get("/requestPassword", (request, response) -> {
            return new ModelAndView(null, "request_password.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void selectColor() {
        get("/selectColor", (request, response) -> {
            return new ModelAndView(null, "select_color.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void selectedColor() {
        post("/selectColor", (request, response) -> {
            QueryParamsMap colorQueryMap = request.queryMap("color");

            Map<String, String[]> map = new HashMap<>();
            map.put("colors", colorQueryMap.values());

            return new ModelAndView(map, "selected_colors.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void selectBeverage() {
        get("/selectBeverage", (request, response) -> {
            return new ModelAndView(null, "select_beverage.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void selectCondiment() {
        get("/selectCondiment", (request, response) -> {
            return new ModelAndView(null, "select_condiment.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void alert() {
        get("/alert", (request, response) -> {
            return new ModelAndView(null, "alert.mustache");
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

    private static void exchangeRate() {
        post("/exchangeRate", (request, response) -> {
            String from = request.queryParams("from");
            String to = request.queryParams("to");

            String sleep = slowResponse(10);

            Map<String, String> map = new HashMap<>();
            map.put("sleep", sleep);
            map.put("from", from);
            map.put("to", to);
            map.put("exchangeRate", "2.07");


            return new ModelAndView(map, "exchange_rate_result.mustache");
        }, new MustacheTemplateEngine());
    }

    private static String slowResponse(int maxSeconds) {
        Random random = new Random();
        return "" + random.nextInt(maxSeconds * 1000);
    }

    private static void newPopupPage() {
        get("/newPopupPage", (request, response) -> {
            return new ModelAndView(null, "new_popup_page.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void buyCurrency() {
        get("/buyCurrency", (request, response) -> {
            return new ModelAndView(null, "buy_currency.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void calculateCurrencyCost() {
        post("/calculateCurrencyCost", (request, response) -> {
            String actionStr = request.queryParams("action");
            String toCurrencyStr = request.queryParams("toCurrency");
            String amountStr = request.queryParams("amount");
            String fromCurrencyStr = request.queryParams("fromCurrency");

            Action action = new Action(actionStr);
            int amount = Integer.parseInt(amountStr);
            Currency to = Currency.getInstance(toCurrencyStr);
            Currency from = Currency.getInstance(fromCurrencyStr);

            BuyCurrency buyCurrency = new BuyCurrency(action, amount, to, from);
            int cost = buyCurrency.getCost();

            Map<String, String> map = new HashMap<>();
            map.put("amount", "" + amountStr);
            map.put("toCurrency", "" + toCurrencyStr);
            map.put("cost", "" + cost);
            map.put("fromCurrency", fromCurrencyStr);

            return new ModelAndView(map, "currency_cost.mustache");
        }, new MustacheTemplateEngine());
    }

    private static void about() {
        get("/about", (request, response) -> {
            return new ModelAndView(null, "about.mustache");
        }, new MustacheTemplateEngine());
    }
}
