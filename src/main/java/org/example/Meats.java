package org.example;

public enum Meats {
    PEPPERONI(1.00, 2.00, 3.00),
    SAUSAGE(1.00, 2.00, 3.00),
    HAM(1.00, 2.00, 3.00),
    BACON(1.00, 2.00, 3.00),
    CHICKEN(1.00, 2.00, 3.00),
    MEATBALL(1.00, 2.00, 3.00);

    private final double personalPrice;
    private final double mediumPrice;
    private final double largePrice;

    Meats(double personalPrice, double mediumPrice, double largePrice) {
        this.personalPrice = personalPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
    }
    public double getPrice(PizzaSizes pizzaSizes){
        switch (pizzaSizes){
            case PERSONAL:
                return this.personalPrice;
            case MEDIUM:
                return this.mediumPrice;
            case LARGE:
                return this.largePrice;
            default:
                return 0;
        }
    }
    public double getExtraMeat(PizzaSizes pizzaSizes){
        return getPrice(pizzaSizes) * .5; //gets meat price for what size you want,
        // and multiply by half, because the price for the extra meats are half of the og
    }
}
