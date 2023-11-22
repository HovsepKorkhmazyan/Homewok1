package OnlineStore;

import OnlineStore.model.Order;
import OnlineStore.model.Product;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ProductStorage implements Serializable {
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void printProducts() {
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void saveOrdersToFile(String filename) throws IOException {
        try (var fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(products);
        }
    }

    public void loadOrdersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            products = (Set<Product>) in.readObject();
        }
    }
}
