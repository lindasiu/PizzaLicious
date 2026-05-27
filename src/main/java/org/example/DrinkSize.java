package org.example;

public enum DrinkSize {
    SMALL(1.50),
    MEDIUM(2.25),
    LARGE(3.00);

    private final double price;

    DrinkSize(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
}
