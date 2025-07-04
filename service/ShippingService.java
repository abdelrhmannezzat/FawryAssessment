package service;

import model.Cart;
import model.Customer;
import model.Product;
import model.Shipping.WeightShippingStrategy;
import repo.ProductRepo;

import java.util.List;

public class ShippingService {
    public void processShipment(Cart cart, ProductRepo productRepo) {
        List<Product> products = cart.getProducts();
        List<Integer> quantities = cart.getQuantities();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getShippingStrategy() instanceof WeightShippingStrategy){
                System.out.println("Processing " + products.get(i).getName());
                productRepo.removeProduct(products.get(i).getName(),quantities.get(i) );
            }
        }
    }
}
