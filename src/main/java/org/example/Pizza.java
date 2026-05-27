package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private PizzaSizes pizzaSize;
    private Crust crust;
    private Sauces sauce;
    private boolean stuffedCrust;

    private List<Meats> meats;
    private List<Meats> extraMeats;
    private List<Cheese> cheeses;
    private List<Cheese> extraCheese;
    private List<RegularToppings> regularToppings;

    public Pizza(PizzaSizes pizzaSize, Crust crust, Sauces sauce, boolean stuffedCrust) {
        this.pizzaSize = pizzaSize;
        this.crust = crust;
        this.sauce = sauce;
        this.stuffedCrust = stuffedCrust;

        this.meats = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        this.cheeses = new ArrayList<>();
        this.extraCheese = new ArrayList<>();
        this.regularToppings = new ArrayList<>();
    }
    public void addMeat(Meats meat){
        meats.add(meat);
    }
    public void addExtraMeat(Meats meat){
        extraMeats.add(meat);
    }
    public void addCheese(Cheese cheese){
        cheeses.add(cheese);
    }
    public void addExtraCheese(Cheese cheese){
        extraCheese.add(cheese);
    }
    public void addRegularTopping(RegularToppings toppings) {
        regularToppings.add(toppings);
    }

    public double totalPrice(){
        double total = 0.0;

        switch(pizzaSize){
            case PERSONAL:
                total += 8.50;
                break;
            case MEDIUM:
                total += 12.00;
                break;
            case LARGE:
                total += 16.50;
                break;
        }
        if(stuffedCrust){
            switch (pizzaSize){
                case PERSONAL:
                    total += 1.00;
                    break;
                case MEDIUM:
                    total += 2.00;
                    break;
                case LARGE:
                    total += 3.00;
                    break;
            }
        }
        for(Meats m : meats){
            total += m.getPrice(pizzaSize);
        }
        for(Meats em : extraMeats){
            total += em.getExtraMeat(pizzaSize);
        }
        for(Cheese c : cheeses){
            total += c.getPrice(pizzaSize);
        }
        for(Cheese ec : extraCheese){
            total += ec.getExtraPrice(pizzaSize);
        }
        return total;
    }
    @Override
    public String toString(){
        String description = pizzaSize + " Pizza with " + crust + " crust and " + sauce + " sauce. ";

        //if they add extras
        if(!meats.isEmpty()){
            description += " Meats: " + meats;
        }
        if(!extraMeats.isEmpty()){
            description += " (Extra: " + extraMeats + ")";
        }
        description += ". Total Price: $" + String.format("%.2f", totalPrice());
        return description;
    }
}
