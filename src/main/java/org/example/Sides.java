package org.example;

public enum Sides {
    GARLIC_KNOTS(1.50),
    RED_PEPPER(0.00),
    PARMESAN(0.00);

    private final double price;

    Sides(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
}
