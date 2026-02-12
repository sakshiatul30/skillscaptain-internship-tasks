import java.util.HashMap;
import java.util.Scanner;

// Product class
class Product {
    String productId;
    String productName;
    String description;
    String manufacturer;
    int warrantyPeriod; // in months

    Product(String productId, String productName, String description,
            String manufacturer, int warrantyPeriod) {
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.manufacturer = manufacturer;
        this.warrantyPeriod = warrantyPeriod;
    }

    void display() {
        System.out.println("Product ID       : " + productId);
        System.out.println("Product Name     : " + productName);
        System.out.println("Description      : " + description);
        System.out.println("Manufacturer     : " + manufacturer);
        System.out.println("Warranty (months): " + warrantyPeriod);
        System.out.println("----------------------------------");
    }
}

// Main system class
public class Main {

    static HashMap<String, Product> products = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n=== Product Registration System ===");
            System.out.println("1. Register Product");
            System.out.println("2. Display All Products");
            System.out.println("3. Search Product by ID");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    registerProduct();
                    break;
                case 2:
                    displayProducts();
                    break;
                case 3:
                    searchProduct();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    // Register product
    static void registerProduct() {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine();

        if (id.isEmpty() || products.containsKey(id)) {
            System.out.println("Invalid or duplicate Product ID.");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Description: ");
        String desc = sc.nextLine();

        System.out.print("Enter Manufacturer: ");
        String manu = sc.nextLine();

        System.out.print("Enter Warranty Period (months): ");
        int warranty = sc.nextInt();

        if (name.isEmpty() || desc.isEmpty() || manu.isEmpty() || warranty <= 0) {
            System.out.println("Invalid input. All fields are required.");
            return;
        }

        Product p = new Product(id, name, desc, manu, warranty);
        products.put(id, p);

        System.out.println("✅ Product registered successfully!");
    }

    // Display all products
    static void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products registered.");
            return;
        }

        for (Product p : products.values()) {
            p.display();
        }
    }

    // Search product
    static void searchProduct() {
        System.out.print("Enter Product ID to search: ");
        String id = sc.nextLine();

        Product p = products.get(id);
        if (p != null) {
            p.display();
        } else {
            System.out.println("Product not found.");
        }
    }

    // Generate report
    static void generateReport() {
        int total = products.size();
        int active = 0;
        int expired = 0;

        for (Product p : products.values()) {
            if (p.warrantyPeriod > 0)
                active++;
            else
                expired++;
        }

        System.out.println("\n=== Product Report ===");
        System.out.println("Total Products  : " + total);
        System.out.println("Active Warranty : " + active);
        System.out.println("Expired Warranty: " + expired);
    }
}
