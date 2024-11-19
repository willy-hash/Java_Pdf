package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;

import java.util.HashMap;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Faker faker = new Faker();

        try{
            User user = new User(faker.name().fullName(), faker.name().lastName(), faker.address().fullAddress(), faker.phoneNumber().phoneNumber());

            //logger.info("USER CREATED " + user.getName());
            double price1 = Double.parseDouble(faker.commerce().price().replace(",", "."));
            double price2 = Double.parseDouble(faker.commerce().price().replace(",", "."));
            double price3 = Double.parseDouble(faker.commerce().price().replace(",", "."));

            ShoppingCartDict.addProduct(new Product("1", faker.commerce().productName(), price1, faker.commerce().material() + " " + faker.color().name(), 1));
            ShoppingCartDict.addProduct(new Product("1", faker.commerce().productName(), price1, faker.commerce().material() + " " + faker.color().name(), 1));
            ShoppingCartDict.addProduct(new Product("80", faker.commerce().productName(), price2, faker.commerce().material() + " " + faker.color().name(), 1));
            ShoppingCartDict.addProduct(new Product("80", faker.commerce().productName(), price2, faker.commerce().material() + " " + faker.color().name(), 1));
            ShoppingCartDict.addProduct(new Product("80", faker.commerce().productName(), price2, faker.commerce().material() + " " + faker.color().name(), 1));
            ShoppingCartDict.addProduct(new Product("5", faker.commerce().productName(), price3, faker.commerce().material() + " " + faker.color().name(), 1));

            double totalPrice = 0;

            //calculate total price of shopping Cart
            for(HashMap<String, String> product: ShoppingCartDict.productsInCar()){
                totalPrice += Double.parseDouble(product.get("TotalPrice"));
            }

            PdfTableWithOpenPDF.createInvoice(new User("william", "Arias", "Daytona Beach", "552014582"), ShoppingCartDict.productsInCar(), String.valueOf(totalPrice));


        }catch (Exception e) {
            //logger.error("ERROR IN CREATE USER " + e);
        }

    }
}