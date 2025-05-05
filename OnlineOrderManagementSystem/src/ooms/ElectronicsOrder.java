package ooms;

public class ElectronicsOrder extends Order {

    public ElectronicsOrder(String id, String itemDescription, double price) {
        super(id, itemDescription, price);
        this.category = "Electronics";
    }

    @Override
    public void processOrder() {
        System.out.println("Processing Electronics Order: " + id);
        this.status = "Processed";
        notifyObservers();
    }
}
