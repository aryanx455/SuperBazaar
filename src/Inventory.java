import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import java.util.Scanner;

public class Inventory {
    private final Map<Integer, Product> productMap;

    public Inventory() {
        productMap = new HashMap<>();
    }

    public void addProduct(String productName, double price, LocalDate manufacturingDate,
                           int quantity, int expirationMonths) {
        try {
            // Validate manufacturing date
            if (manufacturingDate.isAfter(LocalDate.now())) {
                throw new IllegalArgumentException("Invalid manufacturing date. Cannot set a future date.");
            }

            System.out.print("Enter Quantity: ");
            int inputQuantity = new Scanner(System.in).nextInt();
            if (inputQuantity < 0) {
                throw new IllegalArgumentException("Quantity cannot be negative.");
            }
            if(inputQuantity < 5){
                System.out.println("Alerting the manager for low quantity");
            }

            Product product = new Product(productName, price, manufacturingDate, inputQuantity, expirationMonths);
            productMap.put(product.getProductId(), product);
            System.out.println("Product added to inventory: " + product.getProductName() +
                    ", Quantity: " + product.getQuantity());

            // Check for expiration
            if (product.isExpired()) {
                System.out.println("Alert: Product " + product.getProductName() +
                        " is expired. Notifying the manager.");
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please use YYYY-MM-DD.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void removeDefectiveProducts() {
        Iterator<Map.Entry<Integer, Product>> iterator = productMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Product> entry = iterator.next();
            Product product = entry.getValue();
            if (product.getQuantity() <= 0 || product.isExpired()) {
                System.out.println("Removing defective/expired product: " + product.getProductName());
                iterator.remove();
            }
        }
    }

    public Product searchProduct(int productId) {
        return productMap.get(productId);
    }
    public void processOutgoingInventory(int productId, int quantity) {
        Product product = productMap.get(productId);
        if (product != null) {
            if (quantity > 0 && quantity <= product.getQuantity()) {
                product.setQuantity(product.getQuantity() - quantity);
                System.out.println("Outgoing inventory processed for product: " + product.getProductName() +
                        ", Quantity: " + quantity);
                if (product.getQuantity() <= 5) {
                    System.out.println("Alert: Product " + product.getProductName() +
                            " has quantity less than or equal to 5. Notifying the manager.");
                }
            } else {
                System.out.println("Invalid quantity for outgoing inventory.");
            }
        } else {
            System.out.println("Product not found for outgoing inventory.");
        }
    }

    public void displayAllProducts() {
        for (Product product : productMap.values()) {
            System.out.println(product);
        }
    }

    public void sendAlertToManager() {
        for (Product product : productMap.values()) {
            if (product.getQuantity() <= 5) {
                System.out.println("Alert: Product " + product.getProductName() +
                        " has quantity less than or equal to 5. Notifying the manager.");
            }
        }
    }
}

