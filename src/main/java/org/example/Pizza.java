package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private PizzaSizes pizzaSize;
    private Crust crust;
    private Sauces sauce;
    private Cheese cheese;
    private boolean hasExtraCheese;
    private boolean stuffedCrust;

    private List<Meats> meats;
    private List<Meats> extraMeats;
    //private List<Cheese> cheeses;
    //private List<Cheese> extraCheese;
    private List<RegularToppings> regularToppings;

    public Pizza(PizzaSizes pizzaSize, Crust crust, Sauces sauce, Cheese cheese, boolean hasExtraCheese, boolean stuffedCrust) {
        this.pizzaSize = pizzaSize;
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.hasExtraCheese = hasExtraCheese;
        this.stuffedCrust = stuffedCrust;

        this.meats = new ArrayList<>();
        this.extraMeats = new ArrayList<>();
        //this.cheeses = new ArrayList<>();
        //this.extraCheese = new ArrayList<>();
        this.regularToppings = new ArrayList<>();

    }
    public void addMeat(Meats meat){
        meats.add(meat);
    }
    public void addExtraMeat(Meats meat){
        extraMeats.add(meat);
    }
   // public void addCheese(Cheese cheese){
     //   cheeses.add(cheese);
    //}
    //public void addExtraCheese(Cheese cheese){
      //  extraCheese.add(cheese);
    //}
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
        total += cheese.getPrice(pizzaSize);
        if(hasExtraCheese){
            total += cheese.getExtraPrice(pizzaSize);
        }
        for(Meats m : meats){
            total += m.getPrice(pizzaSize);
        }
        for(Meats em : extraMeats){
            total += em.getExtraMeat(pizzaSize);
        }
        for(RegularToppings rt : regularToppings){
            total += 0;
        }

        return total;
    }
    @Override
    public String toString(){
        String exCheese = hasExtraCheese ? " (with extra Cheese)" : "";
        String stuffedC = stuffedCrust ? " (Stuffed Crust Upgrade!)" : "";

        String description = pizzaSize + stuffedC + " Pizza, " + crust + " Crust, " + sauce + " Sauce, Cheese: " + cheese + exCheese;

        //if they add extras
        if(!meats.isEmpty()){
            description += " | Meats: " + meats;
        }
        if(!extraMeats.isEmpty()){
            description += " (Extra: " + extraMeats + ")";
        }
        if(!regularToppings.isEmpty()){
            description += " | Veggies: " + regularToppings;
        }
        description += ". Total Price: $" + String.format("%.2f", totalPrice());
        return description;
    }
}
