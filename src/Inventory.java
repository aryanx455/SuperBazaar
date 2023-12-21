import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private ArrayList<Product> products;

    public Inventory() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product Successfully added to inventory: " + product.getProductName());
    }
    //loops over the entire inventory to check if there are any products
    // with quantity less than equal to 0 or if the product is
    // simply past its expiration date


    public void removeDefectiveProducts() {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getQuantity() <= 0 || product.isExpired()) {
                System.out.println("Removing defective/expired product: " + product.getProductName());
                iterator.remove();
            }
        }
    }

    //Searches a product by their unique ID;
    public Product searchProduct(int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void displayAllProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void monitorInventory() {
        for (Product product : products) {
            if (product.getQuantity() <= 5) {
                System.out.println("Alert: Low quantity for product " + product.getProductName());
            }
        }
        System.out.println("Monitoring Successful : No issues found");
    }
}
