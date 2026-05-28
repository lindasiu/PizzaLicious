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

        for(int i = pizzas.size() - 1; i >= 0; i--){
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
    public boolean isEmpty(){
        return pizzas.isEmpty() && drinks.isEmpty() && garlicKnots.isEmpty();
    }
    public void clearOrder(){
        pizzas.clear();
        drinks.clear();
        garlicKnots.clear();
    }
    public String getReceiptDetailsAsString(){
        StringBuilder sb = new StringBuilder();
        int itemCounter = 1;

        for(int i = pizzas.size() - 1; i >= 0; i--){
            Pizza p = pizzas.get(i);
            sb.append(itemCounter).append(". ").append(p.toString()).append("\n");
            itemCounter++;
        }
        for(int i = drinks.size() - 1; i >= 0; i--){
            DrinkSize d = drinks.get(i);
            sb.append(itemCounter).append(". ").append(d).append(" DRINK - Price: $").append(String.format("%.2f", d.getPrice())).append("\n");
            itemCounter++;
        }
        for(int i = garlicKnots.size() - 1; i >= 0; i--){
            GarlicKnots gk = garlicKnots.get(i);
            sb.append(itemCounter).append(". ").append(gk).append(" - Price: $").append(String.format("%.2f", gk.getPrice())).append("\n");
            itemCounter++;
        }
        sb.append("---------------------------------------\n");
        sb.append(String.format("TOTAL DUE: $%7.2f\n", totalPrice()));
        sb.append("---------------------------------------\n");
        return sb.toString();

    }

}
