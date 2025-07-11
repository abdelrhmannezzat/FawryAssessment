package repo;

import model.Expiring.DateExpiringStrategy;
import model.Expiring.NonExpiringStrategy;
import model.Product;
import model.Shipping.NonShippingStrategy;
import model.Shipping.WeightShippingStrategy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    List<Product> productList;
    public ProductRepo() {
        productList = new ArrayList<>();
        productList.add(
                new Product(
                        "Cheese",
                        5.6,
                        5,
                        new WeightShippingStrategy(2.5),
                        new DateExpiringStrategy(LocalDate.of(2026,5,20))));
        productList.add(
                new Product(
                        "Biscuits",
                        3.2,
                        10,
                        new WeightShippingStrategy(1.0),
                        new DateExpiringStrategy(LocalDate.of(2026,10,1))));
        productList.add(
                new Product(
                        "Mobile Scratch Card",
                        1.5,
                        50,
                        new NonShippingStrategy(),
                        new NonExpiringStrategy()));
        productList.add(
                new Product(
                        "TV",
                        49.99,
                        3,
                        new WeightShippingStrategy(8.0),
                        new NonExpiringStrategy()));
        productList.add(
                new Product(
                        "Honey",
                        5.0,
                        10,
                        new WeightShippingStrategy(0.4),
                        new DateExpiringStrategy(LocalDate.of(2025,1,1))));

    }
    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(String name) {
        for (Product p : productList) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public void removeProduct(String name,int quantity) {
        for (Product p : productList) {
            if (p.getName().equals(name)) {
                p.setQuantity(p.getQuantity() - quantity);
            }
        }
    }
}
