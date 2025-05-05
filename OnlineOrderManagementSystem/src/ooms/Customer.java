package ooms;

public class Customer implements OrderObserver {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Notification to Customer " + name + ": Your order " 
                           + order.getId() + " (" + order.getCategory() + ") is now " 
                           + order.getStatus());
    }
}
