package OnlineStore.storages;

import OnlineStore.model.Order;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class OrderStorage implements Serializable {
    private List<Order> orders = new LinkedList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printAllOrders() {
        for (Order order : orders) {
            System.out.println(order);

        }
    }

    public void saveOrdersToFile(String filename) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(orders);
        }
    }

    public void loadOrdersFromFile(String filename) throws IOException, ClassNotFoundException {
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            orders = (List<Order>) in.readObject();
        }
    }
}
