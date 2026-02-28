package ABC_DSA_training.Day1_Test;
import java.util.*;

abstract class FoodItem {
    private int id;
    private String name;
    private double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public abstract double calculateDiscount();
}

class VegItem extends FoodItem {
    public VegItem(int id, String name, double price) { super(id, name, price); }
    @Override
    public double calculateDiscount() { return getPrice() * 0.10; }
}

class NonVegItem extends FoodItem {
    public NonVegItem(int id, String name, double price) { super(id, name, price); }
    @Override
    public double calculateDiscount() { return getPrice() * 0.05; }
}

class Order {
    private List<FoodItem> cart = new ArrayList<>();

    public void addItem(FoodItem item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            cart.add(item);
        }
    }

    public void showBill() {
        System.out.println("\n--- FINAL BILL ---");
        double total = 0;
        Map<String, Integer> summary = new HashMap<>();
        
        for (FoodItem item : cart) {
            summary.put(item.getName(), summary.getOrDefault(item.getName(), 0) + 1);
            double discountedPrice = item.getPrice() - item.calculateDiscount();
            total += discountedPrice;
        }

        summary.forEach((name, qty) -> System.out.println(name + " x" + qty));
        System.out.printf("Total Amount to Pay (after discounts): Rs.%.2f\n", total);
        System.out.println("-------------------");
    }
}

public class OnlineFoodOrderingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Order myOrder = new Order();

        // Preset Menu
        FoodItem[] menu = {
            new VegItem(1, "Margherita Pizza", 120.0),
            new VegItem(2, "Veg Sandwich    ", 80.0),
            new NonVegItem(3, "Chicken Burger  ", 90.0),
            new NonVegItem(4, "Pepperoni Pizza ", 180.0)
        };
        
        System.out.println("\n=== WELCOME TO JAVA EATS ===");
        
        while (true) {
        	System.out.println();
            for (FoodItem item : menu) {
                String type = (item instanceof VegItem) ? "[Veg]" : "[Non-Veg]";
                System.out.println(item.getId() + ". " + item.getName() + " - Rs." + item.getPrice() + " " + type);
            }
            System.out.println("0. Finish and Checkout");
            System.out.print("\nEnter Item ID to add to cart: ");
            
            int choice = scanner.nextInt();
            if (choice == 0) break;

            if (choice < 1 || choice > menu.length) {
                System.out.println("Invalid choice, try again.");
                continue;
            }

            System.out.print("How many would you like? ");
            int qty = scanner.nextInt();

            myOrder.addItem(menu[choice - 1], qty);
            System.out.println("Added " + qty + " x " + menu[choice - 1].getName() + " to cart.");
        }

        myOrder.showBill();
        scanner.close();
    }
}