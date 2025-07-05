package service;

import model.Cart;
import model.CartItem;
import model.Customer;
import model.Product;
import model.Shipping.WeightShippingStrategy;
import repo.ProductRepo;

import java.util.List;

public class ShippingService {
    public void processShipment(Cart cart, ProductRepo productRepo) {
        List<CartItem> cartItems = cart.getCartItems();
        for (CartItem item : cartItems) {
            if (item.isShippable()){
                System.out.println("Processing " + item.getProduct().getName() + " to be shipped");
                productRepo.removeProduct(item.getProduct().getName(),item.getQuantity() );
            }
        }
    }
}
