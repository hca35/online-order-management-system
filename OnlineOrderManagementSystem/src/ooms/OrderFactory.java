package ooms;

public class OrderFactory {
    public static Order createOrder(String type, String id, String itemDescription, double price) {
        if (type.equalsIgnoreCase("Electronics")) {
            return new ElectronicsOrder(id, itemDescription, price);
        } else if (type.equalsIgnoreCase("Clothing")) {
            return new ClothingOrder(id, itemDescription, price);
        } else if (type.equalsIgnoreCase("Food")) {
            return new FoodOrder(id, itemDescription, price);
        } else {
            throw new IllegalArgumentException("Unknown order type: " + type);
        }
    }
}
