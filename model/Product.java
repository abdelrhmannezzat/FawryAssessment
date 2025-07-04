package model;


import model.Expiring.ExpiringStrategy;
import model.Shipping.ShippingStrategy;

public class Product {
    private String name;
    private Double price;
    private Integer quantity;
    private ShippingStrategy shippingStrategy;
    private ExpiringStrategy expiringStrategy;
    public Product(String name, Double price, Integer quantity, ShippingStrategy shippingStrategy, ExpiringStrategy expiringStrategy) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.shippingStrategy = shippingStrategy;
        this.expiringStrategy = expiringStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public ExpiringStrategy getExpiringStrategy() {
        return expiringStrategy;
    }

    public void setExpiringStrategy(ExpiringStrategy expiringStrategy) {
        this.expiringStrategy = expiringStrategy;
    }
}