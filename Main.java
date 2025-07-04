import model.Cart;
import model.Customer;
import model.Product;
import repo.ProductRepo;
import service.ShippingService;

public class Main {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        Customer customer = new Customer(
                "abdelrhman",
                "abdelrhman@gmail.com",
                150.0,
                new Cart());


        Product cheese = productRepo.getProduct("Cheese");
        int cheeseQuantity = 5;
        customer.addProductToCart(cheese,cheeseQuantity);


        Product biscuits = productRepo.getProduct("Biscuits");
        int biscuitsQuantity = 10;
        customer.addProductToCart(biscuits,biscuitsQuantity);


        Product TV = productRepo.getProduct("TV");
        int TVQuantity = 1;
        customer.addProductToCart(TV,TVQuantity);


        Product mobileScratchCard = productRepo.getProduct("Mobile Scratch Card");
        int mobileScratchCardQuantity = 10;
        customer.addProductToCart(mobileScratchCard,mobileScratchCardQuantity);


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
            shippingService.processShipment(customer.getCart(),productRepo);
            customer.dedcuteBalance(total);
            System.out.println(customer.getBalance());
        }
        else{
            System.out.println("Customer can't afford");
        }





    }
}
