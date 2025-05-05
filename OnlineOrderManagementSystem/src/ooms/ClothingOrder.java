package ooms;

public class ClothingOrder extends Order {

    public ClothingOrder(String id, String itemDescription, double price) {
        super(id, itemDescription, price);
        this.category = "Clothing";
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Clothing Order: " + id);
        this.status = "Processed";
        notifyObservers();
    }
}
