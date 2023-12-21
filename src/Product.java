import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class Product {
    private int productId;
    private String productName;
    private double price;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;
    private int quantity;

    public Product(int productId, String productName, double price, String manufacturingDateStr, int quantity,
                   int expirationDays) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        //Converts string into LocalDate object for easy comparison of expirty and manufacturing date
        this.manufacturingDate = LocalDate.parse(manufacturingDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.quantity = quantity;
        //expiration months are converted to days before adding it to manufacturingDate
        this.expirationDate = manufacturingDate.plusDays(expirationDays);
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