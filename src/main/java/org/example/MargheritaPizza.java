package org.example;

public class MargheritaPizza extends Pizza{
    public MargheritaPizza(PizzaSizes pizzaSize, Crust crust, boolean stuffedCrust){
        super(pizzaSize, crust, Cheese.MOZZARELLA, false, stuffedCrust);

        this.addSauce(Sauces.MARINARA);
        this.addSauce(Sauces.OLIVE_OIL);
        this.addRegularTopping(RegularToppings.TOMATOES);
        this.addRegularTopping(RegularToppings.BASIL);

    }
}
