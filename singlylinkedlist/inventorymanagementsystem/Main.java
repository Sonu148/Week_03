package day_01.singlylinkedlist.inventorymanagementsystem;

public class Main {
    public static void main(String[] args) {
        // Create an inventory object
        Inventory inventory = new Inventory();

        // Insert items into the inventory
        inventory.insertAtBeginning("Milk", 12, 2, 32.3);
        inventory.insertAtLast("Apple", 13, 3, 23.2);
        inventory.insertAtSpecificIndex("Rice", 14, 2, 59.2, 0);

        // Display the inventory
        System.out.println("Initial Inventory:");
        inventory.display();

        // Update the quantity of an item (e.g., update quantity of Apple to 5)
        inventory.updateQuantity(13, 5);
        System.out.println("\nUpdated Inventory (after updating quantity of Apple):");
        inventory.display();

        // Remove an item by Item ID (e.g., remove the item with ID 12)
        inventory.removeByItemId(12);
        System.out.println("\nInventory after removing Milk (ID 12):");
        inventory.display();

        // Calculate total inventory value
        double totalValue = inventory.calculateTotalValue();
        System.out.println("\nTotal Inventory Value: " + totalValue);

        // Search for an item by Item Name (e.g., search for Rice)
        Inventory.Node foundItem = inventory.searchByItemName("Rice");
        if (foundItem != null) {
            System.out.println("\nFound Item by Name - Rice: " + foundItem.itemName + ", ID: " + foundItem.itemId + ", Quantity: " + foundItem.quantity + ", Price: " + foundItem.price);
        } else {
            System.out.println("\nItem not found by Name!");
        }

        // Sort the inventory by Item Name
        inventory.sortByItemName();
        System.out.println("\nSorted Inventory by Item Name:");
        inventory.display();
    }
}
