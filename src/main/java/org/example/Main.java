package org.example;

import java.lang.reflect.Executable;
import java.sql.SQLOutput;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean appRunning = true;

        System.out.println("=========================================");
        System.out.println("        WELCOME TO PIZZA-LICIOUS         ");
        System.out.println("=========================================");

        while(appRunning){
            System.out.println("\n----- HOME SCREEN -----");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("Please select an option: ");

            int choice = -1;

            try{
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("\nERROR: Invalid input! Please enter a number.");
                scanner.nextLine();
                continue;
            }
            if(choice == 0){
                System.out.println("\nThank you for visiting Pizza-Licious! Goodbye...");
                appRunning = false;
            }else if (choice == 1){
                runOrderScreen(scanner);
            }else{
                System.out.println("Invalid selection. Please choose 1 or 0.");
            }
        }
        scanner.close();
    }
    public static void runOrderScreen(Scanner scanner){
        Order currentOrder = new Order();
        boolean orderActive = true;

        while(orderActive){
            System.out.println("\n----- ORDER SCREEN -----");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("Please select an option: ");

            int orderChoice = -1;

            try{
                orderChoice = scanner.nextInt();
                scanner.nextLine();
            }catch (Exception e){
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch(orderChoice) {
                case 1:
                    System.out.println("\nADD PIZZA!");
                    //TODO: Connect your Pizza builder questions here!
                case 2:
                    System.out.println("\n----- Select Drink Size -----");
                    System.out.println("1) Small ($2.00)");
                    System.out.println("1) Medium ($2.50)");
                    System.out.println("1) Large ($3.00)");
                    System.out.println("Choice: ");

                    try {
                        int drinkChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (drinkChoice == 1) {
                            currentOrder.addDrink(DrinkSize.SMALL);
                            System.out.println("Small Drink added!");
                        } else if (drinkChoice == 2) {
                            currentOrder.addDrink(DrinkSize.MEDIUM);
                            System.out.println("Medium Drink added!");
                        } else if (drinkChoice == 3) {
                            currentOrder.addDrink(DrinkSize.LARGE);
                            System.out.println("Large Drink added!");
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.println("\n----- ADD GARLIC KNOTS -----");
                    System.out.println("1) Add an Order of Garlic Knots ($1.50)");
                    System.out.println("2) BACK");
                    System.out.println("Choice: ");
                try{
                    int gknotChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (gknotChoice == 1) {
                        currentOrder.addGarlicKnots(GarlicKnots.GARLIC_KNOTS);
                        System.out.println("Garlic Knots added to order!");
                    }
            }catch(Exception e) {
                    System.out.println("Invalid input.");
                }
                    break;

                case 4:
                    runCheckoutScreen(scanner, currentOrder);
                    orderActive = false;
                    break;
                case 0:
                    System.out.println("\nOrder has been cancelled and deleted.");
                    orderActive = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter number from 0-4.");

            }
        }
    }

    public static void runCheckoutScreen(Scanner scanner, Order order){
        System.out.println("\n----- CHECKOUT -----");
        order.printReceipt();

        System.out.println("\n1) Confirm (Create receipt & go Home");
        System.out.println("2) Cancel (Delete order & go Home)");
        System.out.println("Please select an option: ");

        int checkoutChoice = scanner.nextInt();
        scanner.nextLine();

        if(checkoutChoice == 1){
            System.out.println("\nSaving receipt file... Order Confirmed!");
            //doto: Add your file-writing IO code here
            System.out.println("Returning to Home.");
        }else{
            System.out.println("\nCheckout cancelled. Returning to Home Screen.");
        }
    }
    public static void buildCustomPizza(Scanner scanner, Order currentOrder) {
        System.out.println("\n=========================================");
        System.out.println("         CREATE YOUR CUSTOM PIZZA        ");
        System.out.println("=========================================");

        PizzaSizes selectedSize = null;
        while (selectedSize == null) {
            System.out.println("\n----- Select Pizza Size -----");
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.println("Choice: ");
            try {
                int sizeChoice = scanner.nextInt();
                scanner.nextLine();
                if (sizeChoice == 1) selectedSize = PizzaSizes.PERSONAL;
                else if (sizeChoice == 2) selectedSize = PizzaSizes.MEDIUM;
                else if (sizeChoice == 3) selectedSize = PizzaSizes.LARGE;
                else System.out.println("Invalid input. Please choose a 1, 2, or 3");
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        Crust selectedCrust = null;
        while (selectedCrust == null) {
            System.out.println("\n----- Select Crust Type -----");
            System.out.println("1) Thin");
            System.out.println("2) Regular");
            System.out.println("3) Thick");
            System.out.println("4) Cauliflower");
            System.out.println("Choice: ");
            try {
                int crustChoice = scanner.nextInt();
                scanner.nextLine();
                if (crustChoice == 1) selectedCrust = Crust.THIN;
                else if (crustChoice == 2) selectedCrust = Crust.REGULAR;
                else if (crustChoice == 3) selectedCrust = Crust.THICK;
                else if (crustChoice == 4) selectedCrust = Crust.CAULIFLOWER;
                else System.out.println("Invalid option.");
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
        Sauces selectedSauce = null;
        while (selectedSauce == null) {
            System.out.println("\n----- Select Sauce -----");
            System.out.println("1) Marinara");
            System.out.println("2) Alfredo");
            System.out.println("3) Pesto");
            System.out.println("4) BBQ");
            System.out.println("5) Buffalo");
            System.out.println("6) Olive Oil");
            System.out.println("Choice: ");
            try {
                int sauceChoice = scanner.nextInt();
                scanner.nextLine();

                if (sauceChoice == 1) selectedSauce = Sauces.MARINARA;
                else if (sauceChoice == 2) selectedSauce = Sauces.ALFREDO;
                else if (sauceChoice == 3) selectedSauce = Sauces.PESTO;
                else if (sauceChoice == 4) selectedSauce = Sauces.BBQ;
                else if (sauceChoice == 5) selectedSauce = Sauces.BUFFALO;
                else if (sauceChoice == 6) selectedSauce = Sauces.OLIVE_OIL;
                else System.out.println("Invalid option. Please choose a number between 1-6.");
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
        Cheese selectedCheese = null;
        while (selectedCheese == null) {
            System.out.println("\n----- Select Cheese -----");
            System.out.println("1) Mozzarella");
            System.out.println("2) Parmesan ");
            System.out.println("3) Ricotta");
            System.out.println("4) Goat Cheese");
            System.out.println("5) Buffalo");
            System.out.println("Choice: ");
            try {
                int cheeseChoice = scanner.nextInt();
                ;
                scanner.nextLine();

                if (cheeseChoice == 1) selectedCheese = Cheese.MOZZARELLA;
                else if (cheeseChoice == 2) selectedCheese = Cheese.PARMESAN;
                else if (cheeseChoice == 3) selectedCheese = Cheese.RICOTTA;
                else if (cheeseChoice == 4) selectedCheese = Cheese.GOAT_CHEESE;
                else if (cheeseChoice == 5) selectedCheese = Cheese.BUFFALO;
                else System.out.println("Invalid option.");
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        }
        boolean extraCheeseSelected = false;
        boolean extraCheeses = true;
        while (extraCheeses) {
            System.out.println("\n----- Would you like to add Extra Cheese? -----");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.println("Choice: ");
            try {
                int extraChoice = scanner.nextInt();
                scanner.nextLine();

                if (extraChoice == 1) {
                    extraCheeseSelected = true;
                    extraCheeses = false;
                    System.out.println("Extra cheese added!");
                } else if (extraChoice == 2) {
                    extraCheeseSelected = false;
                    extraCheeses = false;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error. Please enter a number.");
                scanner.nextLine();
            }
        }
        boolean stuffedCrustSelected = false;
        boolean stuffedCrusted = true;
        while (stuffedCrusted) {
            System.out.println("\n----- Would you like for your Pizza to be Stuffed Crust? -----");
            System.out.println("1) Yes (Extra $$$)");
            System.out.println("2) No");
            System.out.println("Choice: ");
            try {
                int stuffedChoice = scanner.nextInt();
                scanner.nextLine();

                if (stuffedChoice == 1) {
                    stuffedCrustSelected = true;
                    stuffedCrusted = false;
                    System.out.println("Stuffed Crust added!");
                } else if (stuffedChoice == 2) {
                    stuffedCrustSelected = false;
                    stuffedCrusted = false;
                } else {
                    System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Please enter a number.");
                scanner.nextLine();
            }
        Pizza customPizza = new Pizza(selectedSize, selectedCrust, selectedSauce, selectedCheese, extraCheeseSelected, stuffedCrustSelected);


    boolean addingToppings = true;
    while(addingToppings){
        System.out.println("\n----- Add Toppings -----");
        System.out.println("1) Add Meat Option");
        System.out.println("2) Add Veggie / Regular Toppings");
        System.out.println("0) Done making pizza!");
        System.out.println("Choice: ");
        try{
            int toppingType = scanner.nextInt();
            scanner.nextLine();

            if(toppingType == 1){
                System.out.println("\n----- Add Meat -----");
                System.out.println("1) Pepperoni\n2) Sausage\n3) Ham\n4) Bacon\n5) Chicken\n6) Meatball");
                System.out.println("Choice:");
                int meatChoice = scanner.nextInt();
                scanner.nextLine();

                Meats selectedMeat = null;
                if(meatChoice == 1) selectedMeat = Meats.PEPPERONI;
                else if(meatChoice == 2) selectedMeat = Meats.SAUSAGE;
                else if (meatChoice == 3) selectedMeat = Meats.HAM;
                else if(meatChoice == 4) selectedMeat = Meats.BACON;
                else if(meatChoice == 5) selectedMeat = Meats.CHICKEN;
                else if(meatChoice == 6) selectedMeat = Meats.MEATBALL;

                if (selectedMeat != null){
                    System.out.println("\n----- Portion -----");
                    System.out.println("1) Regular Portion");
                    System.out.println("2) Extra Meat");
                    System.out.println("Choice: ");
                    int portionChoice = scanner.nextInt();;
                    scanner.nextLine();

                    if(portionChoice == 2){
                        customPizza.addExtraMeat(selectedMeat);
                        System.out.println("EXTRA " + selectedMeat + " added!");
                    }else{
                        customPizza.addMeat(selectedMeat);
                        System.out.println("Regular " + selectedMeat + " added.");
                    }
                }else{
                    System.out.println("Invalid meat selection.");
                }
            }else if (toppingType == 2){
                System.out.println("\n----- Select Veggie -----");
                System.out.println("1) Onions\n2) Mushrooms\n3) Bell Peppers\n4) Olives\n5) Tomatoes\n6) Spinach\n7) Basil\n8) Pineapple\n9) Anchovies");
                System.out.println("Choice: ");
                int vegChoice = scanner.nextInt();
                scanner.nextLine();

                if(vegChoice == 1){
                    customPizza.addRegularTopping();.
                }
            }
        }

    }
}