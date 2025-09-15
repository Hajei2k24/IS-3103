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

        GroceryItem item = new GroceryItem("Fruit", "Apple", 25.0, 100);

        System.out.println("Item Details:");
        System.out.println("Name: " + item.name);
        System.out.println("Type: " + item.type);
        System.out.println("Price: $" + String.format("%.2f", item.price));
        System.out.println("Stock: " + item.stock);

        System.out.print("\nEnter quantity to buy: ");
        int qty = 0;

        while (true) {
            if (scanner.hasNextInt()) {
                qty = scanner.nextInt();
                if (qty <= 0) {
                    System.out.print("Quantity must be positive. Enter again: ");
                } else if (qty > item.stock) {
                    System.out.print("Not enough stock. Available: " + item.stock + ". Enter again: ");
                } else {
                    break;  
                }
            } else {
                System.out.print("Invalid input. Enter a number: ");
                scanner.next(); 
            }
        }

        item.reduceStock(qty);

        System.out.println("\nPurchase successful!");
        System.out.println("You bought " + qty + " x " + item.name);
        System.out.println("Remaining stock: " + item.stock);

        scanner.close();
    }
}