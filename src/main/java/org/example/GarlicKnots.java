package org.example;

public enum GarlicKnots {
    GARLIC_KNOTS(1.50);

    private final double price;

    GarlicKnots(double price){
        this.price = price;
    }
    public double getPrice(){
        return this.price;
    }
}
