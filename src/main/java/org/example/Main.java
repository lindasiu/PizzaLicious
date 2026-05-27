package org.example;

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

            int choice = scanner.nextInt();
            scanner.nextLine();

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

            int orderChoice = scanner.nextInt();
            scanner.nextLine();

            switch(orderChoice){
                case 1:
                    System.out.println("\nADD PIZZA!");
                    //TODO: Connect your Pizza builder questions here!
                case 2:
                    System.out.println("\nADD DRINK!");
                    //TODO: Build your Drink selection logic
                case 3:
                    System.out.println("\nADD GARLIC KNOTS!");
                    //TODO: Build your Garlic Knots logic
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
            //TODO: Add your file-writing IO code here later!
            System.out.println("Returning to Home.");
        }else{
            System.out.println("\nCheckout cancelled. Returning to Home Screen.");
        }
    }
}