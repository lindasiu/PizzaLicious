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
                    System.out.println(`);
            }
        }
    }
}