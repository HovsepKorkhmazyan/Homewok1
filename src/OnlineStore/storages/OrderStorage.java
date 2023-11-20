package OnlineStore;

import OnlineStore.model.Order;

import java.util.LinkedList;
import java.util.List;

public class OrderStorage {
    private List<Order> orders = new LinkedList<>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printAllOrders() {
        for (Order order : orders) {
            System.out.println(order);

        }
    }
}
