package ooms;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    
    public static Order findOrderById(List<Order> orders, String orderId) {
        for (Order order : orders) {
            if (order.getId().equalsIgnoreCase(orderId)) {
                return order;
            }
        }
        return null; 
    }

    public static void main(String[] args) {
        Random random = new Random();
        
        
        String[] orderTypes = {"Electronics", "Clothing", "Food"};
        String[][] itemDescriptions = {
            {"Smartphone", "Laptop", "Tablet"},   // Electronics items
            {"T-Shirt", "Jeans", "Jacket"},       // Clothing items
            {"Pizza", "Burger", "Salad"}          // Food items
        };

       
        Customer customer1 = new Customer("Hakan");
        WarehouseStaff staff1 = new WarehouseStaff("Caner");

        
        int numberOfOrders = 3 + random.nextInt(5);
        List<Order> orders = new ArrayList<>();

        
        for (int i = 0; i < numberOfOrders; i++) {
            int typeIndex = random.nextInt(orderTypes.length);
            String type = orderTypes[typeIndex];
            String[] itemsForType = itemDescriptions[typeIndex];
            String itemDescription = itemsForType[random.nextInt(itemsForType.length)];
            double price = 0.0;
            if (type.equals("Electronics")) {
                price = 500 + random.nextDouble() * 500; // Price between 500 and 1000
            } else if (type.equals("Clothing")) {
                price = 10 + random.nextDouble() * 90; // Price between 10 and 100
            } else if (type.equals("Food")) {
                price = 5 + random.nextDouble() * 15; // Price between 5 and 20
            }
            
            price = Math.round(price * 100.0) / 100.0;

            
            String idPrefix = "";
            if (type.equals("Electronics")) {
                idPrefix = "E";
            } else if (type.equals("Clothing")) {
                idPrefix = "C";
            } else if (type.equals("Food")) {
                idPrefix = "F";
            }
            String id = idPrefix + String.format("%03d", random.nextInt(1000));

            Order order = OrderFactory.createOrder(type, id, itemDescription, price);
            order.addObserver(customer1);
            order.addObserver(staff1);
            orders.add(order);
        }

        System.out.println("----- Processing Random Orders -----");
        for (Order order : orders) {
            order.processOrder();
        }

        System.out.println("\n----- Order Details -----");
        for (Order order : orders) {
            System.out.println("Order " + order.getId() + " - Category: " + order.getCategory() 
                + ", Item: " + order.getItemDescription() + ", Price: $" + order.getPrice() 
                + ", Status: " + order.getStatus());
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("\n----- ORDER TRACKING AND MANAGEMENT SYSTEM -----");
            System.out.println("[1] Track an Order");
            System.out.println("[2] Cancel an Order");
            System.out.println("[3] Exit");
            System.out.print("Your choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch(choice) {
                    case 3:
                        System.out.println("Exiting program. Have a nice day!");
                        running = false;
                        break;
                    case 1:
                        // track order
                        System.out.print("Enter the Order ID to track: ");
                        String trackingId = scanner.nextLine().trim();
                        
                        Order trackedOrder = findOrderById(orders, trackingId);
                        if (trackedOrder != null) {
                            System.out.println("\nOrder " + trackingId + " details:");
                            System.out.println("Category: " + trackedOrder.getCategory());
                            System.out.println("Item: " + trackedOrder.getItemDescription());
                            System.out.println("Price: $" + trackedOrder.getPrice());
                            System.out.println("Status: " + trackedOrder.getStatus());
                        } else {
                            System.out.println("Order " + trackingId + " not found.");
                        }
                        break;
                    case 2:
                        // cancel order
                        System.out.print("Enter the Order ID to cancel: ");
                        String cancelId = scanner.nextLine().trim();
                        
                        Order orderToCancel = findOrderById(orders, cancelId);
                        if (orderToCancel != null) {
                            if (!orderToCancel.getStatus().equals("Cancelled")) {
                                orderToCancel.cancelOrder();
                                System.out.println("Order " + cancelId + " has been cancelled successfully.");
                            } else {
                                System.out.println("Order " + cancelId + " is already cancelled.");
                            }
                        } else {
                            System.out.println("Order " + cancelId + " not found.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice! Please enter 1, 2, or 3.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter only numbers!");
            }
            
            try {
                System.out.println("\nPress ENTER to continue...");
                scanner.nextLine();
            } catch (Exception e) {
             
            }
        }
        scanner.close();
    }
}
