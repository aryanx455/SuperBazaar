import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n1. Add Product\n2. Remove Defective Products\n3. Search Product\n4. Display All Products");
            System.out.println("5. Monitor Inventory\n6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    //Randomly generates a product ID ranging from 1 to 1000
                    int productId = (int)Math.floor(Math.random() * 1000 + 1);
                    System.out.println("Product ID: " + productId);
                    scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Manufacturing Date(yyyy-MM-dd) : ");
                    String manufacturingDate = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.println("Enter expiry(In Months)");
                    int expirationMonth = scanner.nextInt();
                    int expirationDays = expirationMonth * 30;
                    Product newProduct = new Product(productId, productName, price, manufacturingDate, quantity,expirationDays);
                    inventory.addProduct(newProduct);
                    break;

                case 2:
                    inventory.removeDefectiveProducts();
                    break;

                case 3:
                    System.out.print("Enter Product ID to search: ");
                    int searchProductId = scanner.nextInt();
                    Product foundProduct = inventory.searchProduct(searchProductId);
                    if (foundProduct != null) {
                        System.out.println("Product Found: " + foundProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    inventory.displayAllProducts();
                    break;

                case 5:
                    inventory.monitorInventory();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 6);

        scanner.close();
    }
}
