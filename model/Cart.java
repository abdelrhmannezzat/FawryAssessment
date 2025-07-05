package model;

import model.Shipping.NonShippingStrategy;
import model.Shipping.WeightShippingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    public Cart() {
        items = new ArrayList<CartItem>();
    }
    public void addItem(Product product,int quantity) {
        items.add(new CartItem(product,quantity));
    }
    public void removeProduct(Product product) {
        items.removeIf(cartItem -> cartItem.getProduct().equals(product));
    }
    public List<CartItem> getCartItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public Double getTotalProductsPrice() {
        Double total = 0.0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
    public Double getTotalShippingPrice(){
        Double total = 0.0;
        for (CartItem item : items) {
            total += item.getShippingPrice();
        }
        return total;
    }

    public void printCheck(){
        System.out.println("*** Shipment Notice ***");
        for (CartItem item : items) {
            if (item.isShippable()){
                System.out.println(
                        item.getQuantity()
                                + "x"
                                + " "
                                + item.getProduct().getName()
                                + " "
                                + item.getShippingPrice()

                );
            }
        }
        System.out.println();
        System.out.println("*** CheckOut Receipt ***");
        for (CartItem item : items) {
            System.out.println(
                    item.getQuantity()
                            + "x"
                            + " "
                            + item.getProduct().getName()
                            + " "
                            + item.getPrice()

            );
        }
    }
}
