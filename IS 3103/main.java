import java.util.Scanner;

public class main {
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
        GroceryItem item = new GroceryItem("Fruit", "Apple", 25.0, 100);

        System.out.println("Item Details:");
        System.out.println("Name: " + item.name);
        System.out.println("Type: " + item.type);
        System.out.println("Price: $" + item.price);
        System.out.println("Stock: " + item.stock);

        System.out.println("\nReducing stock by 10...");
        item.reduceStock(10);

        System.out.println("Updated Stock: " + item.stock);
    }
}
