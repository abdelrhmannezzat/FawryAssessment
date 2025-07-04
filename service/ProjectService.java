package service;

import model.Customer;
import model.Product;
import repo.ProductRepo;

public class ProjectService {
    public void run(Customer customer, ProductRepo productRepo){
        Double totalPrice = customer.getTotalProductsPrice();
        Double totalShippingPrice = customer.getTotalShippingPrice();
        Double total = totalShippingPrice + totalPrice;
        customer.printCheck();
        System.out.println();
        System.out.println("Products Price: " + totalPrice);
        System.out.println("Shipping Price: " + totalShippingPrice);
        System.out.println("Total Price: " + total);
        System.out.println();
        ShippingService shippingService = new ShippingService();

        if (customer.canAfford(total)){
            if (customer.getCart().getProducts().isEmpty()){
                System.out.println("Cart is empty");
                return;
            }
            shippingService.processShipment(customer.getCart(),productRepo);
            customer.dedcuteBalance(total);
            System.out.println("Customer's balance after deducting: " + customer.getBalance());
            System.out.println();
        }
        else{
            System.out.println("Customer can't afford");
            System.out.println();
        }
    }
}
