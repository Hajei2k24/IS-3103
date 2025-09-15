import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static class GroceryItem {
        String type;
        String name;
        double price;
        int stock;

        public GroceryItem(String type, String name, double price, int stock) {
            this.type = type;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        public void reduceStock(int quantity) {
            if (quantity <= stock) {
                stock = stock - quantity;
            }
        }
    }

    public static void main(String[] args) {
        // Initialize grocery items
        ArrayList<GroceryItem> items = new ArrayList<>();
        items.add(new GroceryItem("Fruit", "Apple", 25.0, 100));
        items.add(new GroceryItem("Vegetable", "Carrot", 20.0, 150));
        items.add(new GroceryItem("Drink", "Cola", 40.0, 80));
        items.add(new GroceryItem("Dairy", "Milk", 55.0, 60));
        items.add(new GroceryItem("Snack", "Chips", 60.0, 50));

        Scanner scanner = new Scanner(System.in);
        double total = 0;

        System.out.println("Welcome to the Grocery Store!");

        while (true) {
            System.out.println("\nItems for sale:");
            for (int i = 0; i < items.size(); i++) {
                GroceryItem item = items.get(i);
                System.out.println((i + 1) + ". " + item.name + " (" + item.type + ") - Price: $" + String.format("%.2f", item.price) + " - Stock: " + item.stock);
            }
            System.out.println("0. Checkout");

            System.out.print("Choose item number to buy (0 to checkout): ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            GroceryItem selectedItem = items.get(choice - 1);

            System.out.print("Enter quantity: ");
            int qty = scanner.nextInt();

            if (qty <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }

            if (qty > selectedItem.stock) {
                System.out.println("Not enough stock. Available: " + selectedItem.stock);
                continue;
            }

            double cost = selectedItem.price * qty;
            total = total + cost;
            selectedItem.reduceStock(qty);

            System.out.println("Added " + qty + " x " + selectedItem.name + " to your cart. Cost: $" + String.format("%.2f", cost));
            System.out.println("Total so far: $" + String.format("%.2f", total));
        }

        System.out.println("\nYour total to pay is: $" + String.format("%.2f", total));
        scanner.close();
    }
}