package OnlineStore.storage;

import OnlineStore.exception.OutOfStockException;
import OnlineStore.model.Product;

public class ProductStorage {
    private Product[] products = new Product[10];
    private int count;

    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (count == products.length) {
            extend();
        }
        products[count++] = product;
    }

    private void extend() {
        Product[] newProducts = new Product[products.length * 2];
        System.arraycopy(products, 0, newProducts, 0, products.length);
        products = newProducts;
    }

    public Product getProductById(int id) throws OutOfStockException {
        for (int i = 0; i < count; i++) {
            if (products[i].getId() == id) {
                if (products[i].getStockQty() <= 0) {
                    throw new OutOfStockException("Product is out of stock.");
                }
                return products[i];
            }
        }
        return null;
    }
}
