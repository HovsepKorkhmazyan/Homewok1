package OnlineStore;

import OnlineStore.model.Order;
import OnlineStore.model.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductStorage {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}
