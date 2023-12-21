import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);

        int choice = 0;
        do {
            try {
                System.out.println("\n1. Add Product\n2. Remove Defective Products\n3. Search Product");
                System.out.println("4. Display All Products\n5. Process Outgoing Inventory\n6. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Product Name: ");
                        scanner.nextLine(); // Consume newline
                        String productName = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter Manufacturing Date (YYYY-MM-DD): ");
                        String manufacturingDateStr = scanner.next();
                        LocalDate manufacturingDate = LocalDate.parse(manufacturingDateStr);

                        System.out.print("Enter Expiry in Months: ");
                        int expirationMonths = scanner.nextInt();

                        // Call addProduct method with validated manufacturing date
                        inventory.addProduct(productName, price, manufacturingDate, 0, expirationMonths);
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
                        System.out.print("Enter Product ID for outgoing inventory: ");
                        int outgoingProductId = scanner.nextInt();
                        System.out.print("Enter Quantity for outgoing inventory: ");
                        int outgoingQuantity = scanner.nextInt();
                        inventory.processOutgoingInventory(outgoingProductId, outgoingQuantity);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine(); // Consume the remaining newline character
            }

        } while (choice != 6);

        scanner.close();
    }
}
