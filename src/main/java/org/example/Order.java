package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private List<DrinkSize> drinks;
    private List<GarlicKnots> garlicKnots;

    public Order(){
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
    }
    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void addDrink(DrinkSize size){
        drinks.add(size);
    }
    public void addGarlicKnots(GarlicKnots order){
        garlicKnots.add(order);
    }
    public double totalPrice(){
        double total = 0;
        for(Pizza p : pizzas){
            total += p.totalPrice();
        }
        for (DrinkSize d : drinks){
            total += d.getPrice();
        }
        for(GarlicKnots gk : garlicKnots){
            total += gk.getPrice();
        }
        return total;
    }
    public void printReceipt(){
        System.out.println("\n=========================================");
        System.out.println("           PIZZA-LICIOUS RECEIPT          ");
        System.out.println("=========================================");

        int itemCounter = 1;

        for(int i = pizzas.size() - 1; i >= pizzas.size(); i--){
            System.out.println(itemCounter + ". " + pizzas.get(i).toString());
            itemCounter++;
        }
        for(int i = drinks.size() - 1; i >= 0; i--){
            DrinkSize d = drinks.get(i);
            System.out.println(itemCounter + ". " + d + " DRINK - Price: $" + String.format("%.2f", d.getPrice()));
            itemCounter++;
        }
        for(int i = garlicKnots.size() - 1; i >= 0; i--){
            GarlicKnots gk = garlicKnots.get(i);
            System.out.println(itemCounter + ". " + gk + " - Price: $" + String.format("%.2f", gk.getPrice()));
        }
        System.out.println("-------------------------------------------");
        System.out.println(String.format("TOTAL DUE: $%7.2f", totalPrice()));
        System.out.println("-------------------------------------------");
    }

}
