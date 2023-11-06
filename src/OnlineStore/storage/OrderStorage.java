package OnlineStore.storage;

import OnlineStore.model.Order;

public class OrderStorage {
    Order[] orders = new Order[10];
    int count = 0;
    public void addOrder(Order order) {
        if (count == orders.length) {
            extend();
        }
        orders[count++] = order;
    }

    private void extend() {
        Order[] newOrders = new Order[orders.length * 2];
        System.arraycopy(orders, 0, newOrders, 0, orders.length);
        orders = newOrders;
    }

    public Order getOrderById(int id) {
        for (int i = 0; i < count; i++) {
            if (orders[i].getId() == id) {
                return orders[i];
            }
        }
        return null;
    }


    public void printAllOrders() {
        for (int i = 0; i < count; i++) {
            if (orders[i] != null) {
                System.out.println(orders[i]);
            }
        }
    }
}


