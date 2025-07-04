package model;

import model.Shipping.NonShippingStrategy;
import model.Shipping.WeightShippingStrategy;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products;
    private List<Integer> quantities;
    public Cart() {
        products = new ArrayList<Product>();
        quantities = new ArrayList<>();
    }
    public void addProduct(Product product,int quantity) {
        products.add(product);
        quantities.add(quantity);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
    public List<Product> getProducts() {
        return products;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }
    public Double getTotalProductsPrice() {
        Double total = 0.0;
        for (int i = 0;i < products.size();i++) {
            total += products.get(i).getPrice() * quantities.get(i);
        }
        return total;
    }
    public Double getTotalShippingPrice(){
        Double total = 0.0;
        for (int i = 0;i < products.size();i++) {
            total += products.get(i).getShippingStrategy().getShippingCost()
                    * quantities.get(i);
        }
        return total;
    }

    public void printCheck(){
        System.out.println("*** Shipment Notice ***");
        for (int i = 0;i < products.size();i++) {
            if (products.get(i).getShippingStrategy() instanceof WeightShippingStrategy){
                System.out.println(
                        quantities.get(i)
                                + "x"
                                + " "
                                + products.get(i).getName()
                                + " "
                                + ((WeightShippingStrategy) products.get(i).getShippingStrategy()).getWeight() * quantities.get(i)

                );
            }
        }
        System.out.println();
        System.out.println("*** CheckOut Receipt ***");
        for (int i = 0;i < products.size();i++) {
            System.out.println(
                    quantities.get(i)
                            + "x"
                            + " "
                            + products.get(i).getName()
                            + " "
                            + products.get(i).getPrice() * quantities.get(i)

            );
        }
    }
}
