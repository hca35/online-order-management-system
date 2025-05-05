package ooms;

public class FoodOrder extends Order {

    public FoodOrder(String id, String itemDescription, double price) {
        super(id, itemDescription, price);
        this.category = "Food";
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Food Order: " + id);
        this.status = "Processed";
        notifyObservers();
    }
}
