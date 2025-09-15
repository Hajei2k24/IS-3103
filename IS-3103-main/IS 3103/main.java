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

        public boolean reduceStock(int quantity) {
            if (quantity <= stock) {
                stock -= quantity;
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<GroceryItem> items = new ArrayList<>();
        items.add(new GroceryItem("Fruit", "Apple", 25.0, 100));
        items.add(new GroceryItem("Vegetable", "Carrot", 20.0, 150));
        items.add(new GroceryItem("Drink", "Cola", 40.0, 80));
        items.add(new GroceryItem("Dairy", "Milk", 55.0, 60));
        items.add(new GroceryItem("Snack", "Chips", 60.0, 50));

        System.out.println("Welcome to the Grocery Store!");

        while (true) {

            System.out.println("\nItems for sale:");
            for (int i = 0; i < items.size(); i++) {
                GroceryItem item = items.get(i);
                System.out.println((i + 1) + ". " + item.name + " (" + item.type + ") - Price: $" 
                    + String.format("%.2f", item.price) + " - Stock: " + item.stock);
            }
            System.out.println("0. Exit");

            System.out.print("Choose item number to buy (0 to exit): ");
            int choice = -1;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); 
                continue;
            }

            if (choice == 0) {
                System.out.println("Thanks for visiting the store!");
                break;
            }

            if (choice < 1 || choice > items.size()) {
                System.out.println("Invalid choice. Please select a valid item number.");
                continue;
            }

            GroceryItem selectedItem = items.get(choice - 1);

            System.out.print("Enter quantity to buy: ");
            int qty = -1;
            if (scanner.hasNextInt()) {
                qty = scanner.nextInt();
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next();
                continue;
            }

            if (qty <= 0) {
                System.out.println("Quantity must be positive.");
                continue;
            }

            if (qty > selectedItem.stock) {
                System.out.println("Sorry, not enough stock. Available: " + selectedItem.stock);
                continue;
            }

            selectedItem.reduceStock(qty);
            double cost = selectedItem.price * qty;
            System.out.println("You bought " + qty + " x " + selectedItem.name + " for $" + String.format("%.2f", cost));
            System.out.println("Remaining stock of " + selectedItem.name + ": " + selectedItem.stock);
        }

        scanner.close();
    }
}