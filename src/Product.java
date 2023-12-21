import java.time.LocalDate;

import java.util.Random;

class Product {
    private final int productId;
    private final String productName;
    private final double price;
    private final LocalDate manufacturingDate;
    private final LocalDate expirationDate;
    private int quantity;

    public Product(String productName, double price, LocalDate manufacturingDate, int quantity, int expirationMonths) {
        this.productId = generateRandomProductId();
        this.productName = productName;
        this.price = price;
        this.manufacturingDate = manufacturingDate;
        this.quantity = quantity;
        this.expirationDate = manufacturingDate.plusMonths(expirationMonths);
    }

    private int generateRandomProductId() {
        return new Random().nextInt(1000) + 1;
    }

    //getters for the Product class
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //for checking if a product is expired
    public boolean isExpired() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(expirationDate);
    }
    //For ease of printing the product contents
    @Override
    public String toString() {
        return "Product [ID=" + productId + ", Name=" + productName + ", Price=" + price +
                ", Manufacturing Date=" + manufacturingDate + ", Expiration Date=" + expirationDate +
                ", Quantity=" + quantity + "]";
    }
}