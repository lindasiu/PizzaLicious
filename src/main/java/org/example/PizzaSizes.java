package org.example;

public enum PizzaSizes {
    PERSONAL(8.50), //8"
    MEDIUM(12.00), //12"
    LARGE(16.50); //16"

    private final double price;

    PizzaSizes(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
