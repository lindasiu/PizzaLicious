package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;

    public Order(){
        this.pizzas = new ArrayList<>();
    }
    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public double totalPrice(){
        double total = 0;
        for(Pizza p : pizzas){
            total += p.totalPrice();
        }
        return total;
    }
    public void printReceipt(){
        System.out.println("\n=========================================");
        System.out.println("           PIZZA-LICIOUS RECEIPT          ");
        System.out.println("=========================================");

        for(int i = 0; i < pizzas.size(); i++){
            System.out.println((i + 1) + ". " + pizzas.get(i).toString());
        }
        System.out.println("-------------------------------------------");
        System.out.println(String.format("TOTAL DUE: $%7.2f", totalPrice()));
        System.out.println("-------------------------------------------");
    }

}
