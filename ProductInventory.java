import java.util.HashMap;

public class ProductInventory {
    public static void main(String[] args) {
        // Creating a HashMap to store productId and quantity
        HashMap<Integer, Integer> inventory = new HashMap<>();

        // Adding three products
        inventory.put(101, 50);  // Product ID 101 with quantity 50
        inventory.put(102, 30);
        inventory.put(103, 20);

        // Updating quantity of product with ID 102
        inventory.put(102, 40);

        // Removing product with ID 101
        inventory.remove(101);

        // Displaying final inventory
        System.out.println("Final Inventory:");
        for (Integer productId : inventory.keySet()) {
            System.out.println("Product ID: " + productId + ", Quantity: " + inventory.get(productId));
        }
    }
}
