package org.example;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    public static List<Product> products = new ArrayList<>();

    public static void addProduct(Product product){
        productsToSell(product);
    }

    public static List<Product> productsInCar(){
        return products;
    }

    public static void productsToSell(Product product){

        boolean finded = false;

        for(int i=0; i<products.size(); i++){
            if(products.get(i).getId().equals(product.getId())){

                double newPrice = products.get(i).getPrice();
                int newQuantity = products.get(i).getQuantity();

                newPrice += product.getPrice();
                newQuantity += 1;

                products.get(i).setQuantity(newQuantity);
                products.get(i).setPrice(newPrice);

                finded = true;
                break;

            }
        }

        if (!finded){
            products.add(new Product(product.getId(), product.getName(), product.getPrice() ,product.getDescription(), 1));
        }

    }

}
