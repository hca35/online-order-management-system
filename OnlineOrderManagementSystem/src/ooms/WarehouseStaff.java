package ooms;

public class WarehouseStaff implements OrderObserver {
    private String name;

    public WarehouseStaff(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Notification to Warehouse Staff " + name + ": Order " 
                           + order.getId() + " (" + order.getCategory() + ") status: " 
                           + order.getStatus());
    }
}
