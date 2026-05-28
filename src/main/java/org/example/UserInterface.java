package org.example;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UserInterface {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    private Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean appRunning = true;

        System.out.println(ANSI_PURPLE + "=========================================");
        System.out.println("        WELCOME TO PIZZA-LICIOUS         ");
        System.out.println("=========================================" + ANSI_RESET);

        while (appRunning) {
            System.out.println(ANSI_YELLOW + "\n----- HOME SCREEN -----" + ANSI_RESET);
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Please select an option: ");

            int choice = -1;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "\nERROR: Invalid input! Please enter a number." + ANSI_RESET);
                scanner.nextLine();
                continue;
            }

            if (choice == 0) {
                System.out.println(ANSI_PURPLE + "\nThank you for visiting Pizza-Licious! Goodbye..." + ANSI_RESET);
                appRunning = false;
            } else if (choice == 1) {
                // Call the order screen method
                runOrderScreen();
            } else {
                System.out.println(ANSI_RED + "Invalid selection. Please choose 1 or 0." + ANSI_RESET);
            }
        }
        scanner.close();
    }


    public void runOrderScreen() {
        Order currentOrder = new Order();
        boolean orderActive = true;

        while (orderActive) {
            System.out.println(ANSI_YELLOW + "\n----- ORDER SCREEN -----" + ANSI_RESET);
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Sides");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Please select an option: ");

            int orderChoice = -1;

            try {
                orderChoice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Invalid input. Please enter a number." + ANSI_RESET);
                scanner.nextLine();
                continue;
            }

            switch (orderChoice) {
                case 1:
                    buildCustomPizza(currentOrder);
                    break;
                case 2:
                    System.out.println(ANSI_YELLOW + "\n----- Select Drink Size -----" + ANSI_RESET);
                    System.out.println("1) Small ($2.00)");
                    System.out.println("2) Medium ($2.50)");
                    System.out.println("3) Large ($3.00)");
                    System.out.print("Choice: ");

                    try {
                        int drinkChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (drinkChoice == 1) {
                            currentOrder.addDrink(DrinkSize.SMALL);
                            System.out.println(ANSI_CYAN + "Small Drink added!" + ANSI_RESET);
                        } else if (drinkChoice == 2) {
                            currentOrder.addDrink(DrinkSize.MEDIUM);
                            System.out.println(ANSI_CYAN + "Medium Drink added!" + ANSI_RESET);
                        } else if (drinkChoice == 3) {
                            currentOrder.addDrink(DrinkSize.LARGE);
                            System.out.println(ANSI_CYAN + "Large Drink added!" + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_RED + "Invalid choice." + ANSI_RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Invalid input." + ANSI_RESET);
                        scanner.nextLine();
                    }
                    break;

                case 3:
                    System.out.println(ANSI_YELLOW + "\n----- ADD GARLIC KNOTS -----" + ANSI_RESET);
                    System.out.println("1) Add an Order of Garlic Knots ($1.50)");
                    System.out.println("2) Add Red Pepper Packets (FREE)");
                    System.out.println("3) Add Side of Parmesan (FREE)");
                    System.out.println("4) BACK");
                    System.out.print("Choice: ");

                    try {
                        int sideChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (sideChoice == 1) {
                            currentOrder.addSides(Sides.GARLIC_KNOTS);
                            System.out.println(ANSI_CYAN + "Garlic Knots added to order!" + ANSI_RESET);
                        } else if (sideChoice == 2) {
                            currentOrder.addSides(Sides.RED_PEPPER);
                            System.out.println(ANSI_CYAN + "Red Pepper Packets added to order!" + ANSI_RESET);
                        } else if (sideChoice == 3) {
                            currentOrder.addSides(Sides.PARMESAN);
                            System.out.println(ANSI_CYAN + "Side of Parmesan added to order!" + ANSI_RESET);
                        } else if (sideChoice == 4) {
                            System.out.println(ANSI_CYAN + "Returning to Main Menu..." + ANSI_RESET);
                        } else {
                            System.out.println(ANSI_RED + "Invalid choice." + ANSI_RESET);
                        }
                    } catch (Exception e) {
                        System.out.println(ANSI_RED + "Invalid input." + ANSI_RESET);
                        scanner.nextLine();
                    }
                    break;

                case 4:
                    runCheckoutScreen(currentOrder);
                    if (currentOrder.isEmpty()) {
                        return;
                    }
                    break;
                case 0:
                    System.out.println(ANSI_RED + "\nOrder has been cancelled and deleted." + ANSI_RESET);
                    currentOrder.clearOrder();
                    return;
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Please enter a number from 0-4." + ANSI_RESET);
            }
        }
    }


    public void buildCustomPizza(Order currentOrder) {
        System.out.println(ANSI_PURPLE + "\n=========================================");
        System.out.println("         CREATE YOUR CUSTOM PIZZA        ");
        System.out.println("=========================================" + ANSI_RESET);

        PizzaSizes selectedSize = null;
        while (selectedSize == null) {
            System.out.println(ANSI_YELLOW + "\n----- Select Pizza Size -----" + ANSI_RESET);
            System.out.println("1) Small");
            System.out.println("2) Medium");
            System.out.println("3) Large");
            System.out.print("Choice: ");
            try {
                int sizeChoice = scanner.nextInt();
                scanner.nextLine();
                if (sizeChoice == 1) selectedSize = PizzaSizes.PERSONAL;
                else if (sizeChoice == 2) selectedSize = PizzaSizes.MEDIUM;
                else if (sizeChoice == 3) selectedSize = PizzaSizes.LARGE;
                else System.out.println(ANSI_RED + "Invalid input. Please choose a 1, 2, or 3" + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Invalid input. Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        Crust selectedCrust = null;
        while (selectedCrust == null) {
            System.out.println(ANSI_YELLOW + "\n----- Select Crust Type -----" + ANSI_RESET);
            System.out.println("1) Thin");
            System.out.println("2) Regular");
            System.out.println("3) Thick");
            System.out.println("4) Cauliflower");
            System.out.print("Choice: ");
            try {
                int crustChoice = scanner.nextInt();
                scanner.nextLine();
                if (crustChoice == 1) selectedCrust = Crust.THIN;
                else if (crustChoice == 2) selectedCrust = Crust.REGULAR;
                else if (crustChoice == 3) selectedCrust = Crust.THICK;
                else if (crustChoice == 4) selectedCrust = Crust.CAULIFLOWER;
                else System.out.println(ANSI_RED + "Invalid option." +  ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        Sauces selectedSauce = null;
        while (selectedSauce == null) {
            System.out.println(ANSI_YELLOW + "\n----- Select Sauce -----" + ANSI_RESET);
            System.out.println("1) Marinara");
            System.out.println("2) Alfredo");
            System.out.println("3) Pesto");
            System.out.println("4) BBQ");
            System.out.println("5) Buffalo");
            System.out.println("6) Olive Oil");
            System.out.print("Choice: ");
            try {
                int sauceChoice = scanner.nextInt();
                scanner.nextLine();

                if (sauceChoice == 1) selectedSauce = Sauces.MARINARA;
                else if (sauceChoice == 2) selectedSauce = Sauces.ALFREDO;
                else if (sauceChoice == 3) selectedSauce = Sauces.PESTO;
                else if (sauceChoice == 4) selectedSauce = Sauces.BBQ;
                else if (sauceChoice == 5) selectedSauce = Sauces.BUFFALO;
                else if (sauceChoice == 6) selectedSauce = Sauces.OLIVE_OIL;
                else System.out.println(ANSI_RED + "Invalid option. Please choose a number between 1-6." + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        Cheese selectedCheese = null;
        while (selectedCheese == null) {
            System.out.println(ANSI_YELLOW + "\n----- Select Cheese -----" + ANSI_RESET);
            System.out.println("1) Mozzarella");
            System.out.println("2) Parmesan ");
            System.out.println("3) Ricotta");
            System.out.println("4) Goat Cheese");
            System.out.println("5) Buffalo");
            System.out.print("Choice: ");
            try {
                int cheeseChoice = scanner.nextInt();
                scanner.nextLine();

                if (cheeseChoice == 1) selectedCheese = Cheese.MOZZARELLA;
                else if (cheeseChoice == 2) selectedCheese = Cheese.PARMESAN;
                else if (cheeseChoice == 3) selectedCheese = Cheese.RICOTTA;
                else if (cheeseChoice == 4) selectedCheese = Cheese.GOAT_CHEESE;
                else if (cheeseChoice == 5) selectedCheese = Cheese.BUFFALO;
                else System.out.println(ANSI_RED + "Invalid option." + ANSI_RESET);
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        boolean extraCheeseSelected = false;
        boolean extraCheeses = true;
        while (extraCheeses) {
            System.out.println(ANSI_YELLOW + "\n----- Would you like to add Extra Cheese? -----" + ANSI_RESET);
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Choice: ");
            try {
                int extraChoice = scanner.nextInt();
                scanner.nextLine();

                if (extraChoice == 1) {
                    extraCheeseSelected = true;
                    extraCheeses = false;
                    System.out.println(ANSI_CYAN + "Extra cheese added!" + ANSI_RESET);
                } else if (extraChoice == 2) {
                    extraCheeseSelected = false;
                    extraCheeses = false;
                } else {
                    System.out.println(ANSI_RED + "Invalid option." + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Error. Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        boolean stuffedCrustSelected = false;
        boolean stuffedCrusted = true;
        while (stuffedCrusted) {
            System.out.println(ANSI_YELLOW + "\n----- Would you like for your Pizza to be Stuffed Crust? -----" + ANSI_RESET);
            System.out.println("1) Yes (Extra $$$)");
            System.out.println("2) No");
            System.out.print("Choice: ");
            try {
                int stuffedChoice = scanner.nextInt();
                scanner.nextLine();

                if (stuffedChoice == 1) {
                    stuffedCrustSelected = true;
                    stuffedCrusted = false;
                    System.out.println(ANSI_CYAN + "Stuffed Crust added!" + ANSI_RESET);
                } else if (stuffedChoice == 2) {
                    stuffedCrustSelected = false;
                    stuffedCrusted = false;
                } else {
                    System.out.println(ANSI_RED + "Invalid option." + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }

        Pizza customPizza = new Pizza(selectedSize, selectedCrust, selectedSauce, selectedCheese, extraCheeseSelected, stuffedCrustSelected);

        boolean addingToppings = true;
        while (addingToppings) {
            System.out.println(ANSI_YELLOW + "\n----- Add Toppings -----" + ANSI_RESET);
            System.out.println("1) Add Meat Option");
            System.out.println("2) Add Veggie / Regular Toppings");
            System.out.println("0) Done making pizza!");
            System.out.print("Choice: ");
            try {
                int toppingType = scanner.nextInt();
                scanner.nextLine();

                if (toppingType == 1) {
                    System.out.println(ANSI_YELLOW + "\n----- Add Meat -----" + ANSI_RESET);
                    System.out.println("1) Pepperoni\n2) Sausage\n3) Ham\n4) Bacon\n5) Chicken\n6) Meatball");
                    System.out.print("Choice: ");
                    int meatChoice = scanner.nextInt();
                    scanner.nextLine();

                    Meats selectedMeat = null;
                    if (meatChoice == 1) selectedMeat = Meats.PEPPERONI;
                    else if (meatChoice == 2) selectedMeat = Meats.SAUSAGE;
                    else if (meatChoice == 3) selectedMeat = Meats.HAM;
                    else if (meatChoice == 4) selectedMeat = Meats.BACON;
                    else if (meatChoice == 5) selectedMeat = Meats.CHICKEN;
                    else if (meatChoice == 6) selectedMeat = Meats.MEATBALL;

                    if (selectedMeat != null) {
                        System.out.println(ANSI_YELLOW + "\n----- Portion -----" + ANSI_RESET);
                        System.out.println("1) Regular Portion");
                        System.out.println("2) Extra Meat");
                        System.out.print("Choice: ");
                        int portionChoice = scanner.nextInt();
                        scanner.nextLine();

                        if (portionChoice == 2) {
                            customPizza.addExtraMeat(selectedMeat);
                            System.out.println(ANSI_CYAN + "EXTRA " + selectedMeat + " added!" + ANSI_RESET);
                        } else {
                            customPizza.addMeat(selectedMeat);
                            System.out.println(ANSI_CYAN + "Regular " + selectedMeat + " added." + ANSI_RESET);
                        }
                    } else {
                        System.out.println(ANSI_RED + "Invalid meat selection." + ANSI_RESET);
                    }
                } else if (toppingType == 2) {
                    System.out.println(ANSI_YELLOW + "\n----- Select Veggie -----" + ANSI_RESET);
                    System.out.println("1) Onions\n2) Mushrooms\n3) Bell Peppers\n4) Olives\n5) Tomatoes\n6) Spinach\n7) Basil\n8) Pineapple\n9) Anchovies");
                    System.out.print("Choice: ");
                    int vegChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (vegChoice == 1) {
                        customPizza.addRegularTopping(RegularToppings.ONIONS);
                        System.out.println(ANSI_CYAN + "Onions added." + ANSI_RESET);
                    } else if (vegChoice == 2) {
                        customPizza.addRegularTopping(RegularToppings.MUSHROOMS);
                        System.out.println(ANSI_CYAN + "Mushrooms added." + ANSI_RESET);
                    } else if (vegChoice == 3) {
                        customPizza.addRegularTopping(RegularToppings.BELL_PEPPERS);
                        System.out.println(ANSI_CYAN + "Bell Peppers added." + ANSI_RESET);
                    } else if (vegChoice == 4) {
                        customPizza.addRegularTopping(RegularToppings.OLIVES);
                        System.out.println(ANSI_CYAN + "Olives added." + ANSI_RESET);
                    } else if (vegChoice == 5) {
                        customPizza.addRegularTopping(RegularToppings.TOMATOES);
                        System.out.println(ANSI_CYAN + "Tomatoes added." + ANSI_RESET);
                    } else if (vegChoice == 6) {
                        customPizza.addRegularTopping(RegularToppings.SPINACH);
                        System.out.println(ANSI_CYAN + "Spinach added." + ANSI_RESET);
                    } else if (vegChoice == 7) {
                        customPizza.addRegularTopping(RegularToppings.BASIL);
                        System.out.println(ANSI_CYAN + "Basil added." + ANSI_RESET);
                    } else if (vegChoice == 8) {
                        customPizza.addRegularTopping(RegularToppings.PINEAPPLE);
                        System.out.println(ANSI_CYAN + "Pineapple added." + ANSI_RESET);
                    } else if (vegChoice == 9) {
                        customPizza.addRegularTopping(RegularToppings.ANCHOVIES);
                        System.out.println(ANSI_CYAN + "Anchovies added." + ANSI_RESET);
                    } else {
                        System.out.println(ANSI_RED + "Invalid topping selection." + ANSI_RESET);
                    }
                } else if (toppingType == 0) {
                    addingToppings = false;
                } else {
                    System.out.println(ANSI_RED + "Invalid selection." + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "ERROR." + ANSI_RESET);
                scanner.nextLine();
            }
        }
        currentOrder.addPizza(customPizza);
        System.out.println(ANSI_CYAN + "\nPizza is complete... adding to order now!" + ANSI_RESET);
    }


    public void runCheckoutScreen(Order currentOrder) {
        if (currentOrder.isEmpty()) {
            System.out.println(ANSI_RED + "\nCart is empty!" + ANSI_RESET);
            return;
        }

        System.out.println(ANSI_PURPLE + "\n=========================================");
        System.out.println("             CHECKOUT SCREEN             ");
        System.out.println("==========================================" + ANSI_RESET);

        currentOrder.printReceipt();

        boolean inCheckout = true;
        while (inCheckout) {
            System.out.println(ANSI_YELLOW + "\nPlease select an option:" + ANSI_RESET);
            System.out.println("1) Confirm Order");
            System.out.println("2) Cancel Order");
            System.out.print("Choice: ");
            try {
                int checkoutChoice = scanner.nextInt();
                scanner.nextLine();

                if (checkoutChoice == 1) {
                    LocalDateTime now = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"); // Changed hh to HH for 24hr format
                    String formattedDate = now.format(formatter);
                    String fileName = "Receipts/receipt_" + formattedDate + ".txt";

                    try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
                        writer.write(ANSI_PURPLE + "=========================================\n");
                        writer.write("         PIZZA-LICIOUS OFFICIAL RECEIPT  \n");
                        writer.write("=========================================\n\n" + ANSI_RESET);

                        writer.write(currentOrder.getReceiptDetailsAsString());

                        writer.write(ANSI_PURPLE + "\n=========================================\n" + ANSI_RESET);
                        writer.write(ANSI_CYAN + "Thank you for dining with Pizza-Licious!\n" + ANSI_RESET);

                        System.out.println(ANSI_CYAN + "\nOrder Confirmed! Receipt successfully saved to: " + ANSI_RESET + fileName);
                    } catch (java.io.IOException e) {
                        System.out.println(ANSI_RED + "ERROR: Could not write file. Make sure the 'Receipts' folder exists." + ANSI_RESET);
                    }
                    currentOrder.clearOrder();
                    inCheckout = false;
                } else if (checkoutChoice == 2) {
                    currentOrder.clearOrder();
                    System.out.println(ANSI_RED + "Order has been canceled, cart is now empty." + ANSI_RESET);
                    inCheckout = false;
                } else {
                    System.out.println(ANSI_RED + "Invalid selection. Please choose 1 or 2." + ANSI_RESET);
                }
            } catch (Exception e) {
                System.out.println(ANSI_RED + "Please enter a number." + ANSI_RESET);
                scanner.nextLine();
            }
        }
    }
}
