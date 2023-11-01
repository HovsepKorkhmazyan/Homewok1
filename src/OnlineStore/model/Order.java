package OnlineStore.model;

import OnlineStore.model.Product;
import OnlineStore.model.User;

import java.util.Date;

public class Order {
    private int id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private OrderStatus orderStatus;
    private int qty;
    private PaymentMethod paymentMethod;

    public enum OrderStatus {
        NEW, DELIVERED, CANCELED
    }

    public enum PaymentMethod {
        CARD, CASH, PAYPAL
    }


    public Order(int id, User user, Product product, Date date, double price, OrderStatus orderStatus, int qty, PaymentMethod paymentMethod) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (qty <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        this.id = id;
        this.user = user;
        this.product = product;
        this.date = new Date();
        this.price = price;
        this.orderStatus = orderStatus;
        this.qty = qty;
        this.paymentMethod = paymentMethod;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", user=" + user + ", product=" + product + ", date=" + date
                + ", price=" + price + ", orderStatus=" + orderStatus + ", qty=" + qty
                + ", paymentMethod=" + paymentMethod + "]";
    }
}

