# Online Order Management System (OOMS)

This is a Java-based console application simulating an e-commerce order management system.  
It allows the creation, processing, tracking, and cancellation of different order types (Electronics, Clothing, Food) using design patterns.

## 🛠️ Technologies Used
- Java
- Object-Oriented Programming (OOP)
- Factory Method Pattern
- Observer Pattern

## 📦 Features
- Create random orders dynamically.
- Track and cancel orders via console.
- Real-time notifications to customers and warehouse staff.
- Extensible architecture for adding new order types or observers.

## 🧩 Design Patterns
- **Factory Method**: To instantiate different types of orders without changing client code.
- **Observer Pattern**: To notify customers and warehouse staff automatically when an order's status changes.

## 🧪 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/hca35/online-order-management-system.git

📁 Project Structure

ooms/
- Order.java
- FoodOrder.java
- ElectronicsOrder.java
- ClothingOrder.java
- OrderFactory.java
- OrderObserver.java
- Customer.java
- WarehouseStaff.java
- Main.java
