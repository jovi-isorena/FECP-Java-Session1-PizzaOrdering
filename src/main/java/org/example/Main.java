package org.example;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String selection;
        ArrayList<String> pizzaTypes = new ArrayList<>();
        ArrayList<Integer> quantities = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Add Order\n2. Update Order\n3. Remove Order\n4. View Orders\n5. Exit");
        while(true){
            System.out.print("\nChoose option: ");
            String pizzaType, sQuantity;
            int iQuantity, orderIndex;
            selection = sc.nextLine();
            switch (selection){
                case "1": //add
                    System.out.print("Pizza type: ");
                    pizzaType = sc.nextLine();
                    System.out.print("Quantity: ");
//                    sQuantity = sc.nextLine();
                    iQuantity = Integer.parseInt(sc.nextLine());
                    addOrder(pizzaTypes, quantities, pizzaType, iQuantity);
                    break;
                case "2": //update
                    System.out.print("Order number to update: ");
                    orderIndex = Integer.parseInt(sc.nextLine());
                    System.out.print("New quantity: ");
                    iQuantity = Integer.parseInt(sc.nextLine());
                    updateOrder(quantities, orderIndex-1, iQuantity);
                    break;
                case "3": //remove
                    System.out.print("Order number to remove: ");
                    orderIndex = Integer.parseInt(sc.nextLine());
                    removeOrder(pizzaTypes, quantities, orderIndex-1);
                    break;
                case "4": //view
                    printOrders(pizzaTypes, quantities);
                    break;
                case "5": //exit
                    System.out.println("---Thank you!---");
                    return;
            }
        }
    }
    public static void addOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, String pizzaType, int quantity){
        if(quantity <= 0){
            System.out.println("Quantity must be positive");
            return;
        }
        pizzas.add(pizzaType);
        quantities.add(quantity);
    }
    public static void updateOrder(ArrayList<Integer> quantities, int index, int newQuantity){
        if(quantities.isEmpty()) return;
        if(newQuantity <= 0){
            System.out.println("Quantity must be positive");
            return;
        }
        quantities.set(index, newQuantity);
    }
    public static void removeOrder(ArrayList<String> pizzas, ArrayList<Integer> quantities, int index){
        if(quantities.isEmpty()) return;
        pizzas.remove(index);
        quantities.remove(index);
    }
    public static void printOrders(ArrayList<String> pizzas, ArrayList<Integer> quantities){
        System.out.println("\n--- Current Orders ---");
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.printf("%d. %s x %d\n", i+1, pizzas.get(i), quantities.get(i));

        }
    }

}