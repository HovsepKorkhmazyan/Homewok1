package OnlineStore.model;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int stockQty;
    private ProductType type;

    public enum ProductType {
        ELECTRONICS, CLOTHING, BOOKS
    }


    public Product(int id, String name, String description, double price, int stockQty, ProductType type) {
        if (name == null) {
            throw new IllegalArgumentException("Product name cannot be null or empty.");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (stockQty < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative.");
        }
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQty = stockQty;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
                + ", stockQty=" + stockQty + ", type=" + type + "]";
    }
}

