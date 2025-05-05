package ooms;

import java.util.ArrayList;
import java.util.List;

public abstract class Order {
    protected String id;
    protected String category;
    protected String itemDescription;
    protected double price;
    protected String status;

    
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(String id, String itemDescription, double price) {
        this.id = id;
        this.itemDescription = itemDescription;
        this.price = price;
        this.status = "Created";
    }

    
    public String getId() { return id; }
    public String getCategory() { return category; }
    public String getItemDescription() { return itemDescription; }
    public double getPrice() { return price; }
    public String getStatus() { return status; }

    
    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    protected void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public abstract void processOrder();

    public void cancelOrder() {
        this.status = "Cancelled";
        notifyObservers();
    }
}
