package org.example;

public enum Cheese {
    MOZZARELLA(0.75, 1.50, 2.75, 0.30, 0.60, 0.90),
    PARMESAN(0.75, 1.50, 2.75, 0.30, 0.60, 0.90),
    RICOTTA(0.75, 1.50, 2.75, 0.30, 0.60, 0.90),
    GOAT_CHEESE(0.75, 1.50, 2.75, 0.30, 0.60, 0.90),
    BUFFALO(0.75, 1.50, 2.75, 0.30, 0.60, 0.90);

    private final double personalPrice;
    private final double mediumPrice;
    private final double largePrice;
    private final double extraPersonal;
    private final double extraMedium;
    private final double extraLarge;

    Cheese(double personalPrice, double mediumPrice, double largePrice, double extraPersonal, double extraMedium, double extraLarge) {
        this.personalPrice = personalPrice;
        this.mediumPrice = mediumPrice;
        this.largePrice = largePrice;
        this.extraPersonal = extraPersonal;
        this.extraMedium = extraMedium;
        this.extraLarge = extraLarge;
    }
    public double getPrice(PizzaSizes pizzaSizes) {
        switch (pizzaSizes) {
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
    public double getExtraPrice(PizzaSizes pizzaSizes){
        switch (pizzaSizes){
            case PERSONAL:
                return this.extraPersonal;
            case MEDIUM:
                return this.extraMedium;
            case LARGE:
                return this.extraLarge;
            default:
                return 0;

        }
    }
}
