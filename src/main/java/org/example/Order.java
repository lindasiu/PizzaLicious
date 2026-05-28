package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    private List<Pizza> pizzas;
    private List<DrinkSize> drinks;
    private List<Sides> sides;

    public Order(){
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.sides = new ArrayList<>();
    }
    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
    }
    public void addDrink(DrinkSize size){
        drinks.add(size);
    }
    public void addSides(Sides side){
        sides.add(side);
    }
    public double totalPrice(){
        double total = 0;
        for(Pizza p : pizzas){
            total += p.totalPrice();
        }
        for (DrinkSize d : drinks){
            total += d.getPrice();
        }
        for(Sides s : sides){
            total += s.getPrice();
        }
        return total;
    }
    public void printReceipt(){
        System.out.println(ANSI_PURPLE + "\n=========================================");
        System.out.println("           PIZZA-LICIOUS RECEIPT          ");
        System.out.println("=========================================" + ANSI_RESET);

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
        for(int i = sides.size() - 1; i >= 0; i--){
            Sides s = sides.get(i);
            System.out.println(itemCounter + ". " + s + " - Price: $" + String.format("%.2f", s.getPrice()));
        }
        System.out.println(ANSI_YELLOW + "-------------------------------------------");
        System.out.println(String.format("TOTAL DUE: $%7.2f", totalPrice()));
        System.out.println("-------------------------------------------" + ANSI_RESET);
    }
    public boolean isEmpty(){
        return pizzas.isEmpty() && drinks.isEmpty() && sides.isEmpty();
    }
    public void clearOrder(){
        pizzas.clear();
        drinks.clear();
        sides.clear();
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
        for(int i = sides.size() - 1; i >= 0; i--){
            Sides gk = sides.get(i);
            sb.append(itemCounter).append(". ").append(gk).append(" - Price: $").append(String.format("%.2f", gk.getPrice())).append("\n");
            itemCounter++;
        }
        sb.append(ANSI_YELLOW + "---------------------------------------\n");
        sb.append(String.format("TOTAL DUE: $%7.2f\n", totalPrice()));
        sb.append("---------------------------------------\n" + ANSI_RESET);
        return sb.toString();

    }

}
