import model.Cart;
import model.Customer;
import model.Product;
import repo.ProductRepo;
import service.ProjectService;
import service.ShippingService;

public class Main {
    public static void main(String[] args) {
        ProjectService projectService = new ProjectService();
        /*
            Customer 1 will have no problems,
            This customer is buying 4 products, three of them can be shipped and one
            cannot be shipped which is Mobile Scratch card, so it will not be included
            in the shipping process.
         */
        System.out.println("Customer 1:  \n");
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

        projectService.run(customer,productRepo);

        /*
            Customer 2 will have a problem,
             because the honey is expired.
         */
        System.out.println("Customer 2:  \n");
        Customer customer2 = new Customer(
                "mohamed",
                "mohamed@gmail.com",
                100.0,
                new Cart());

        Product honey = productRepo.getProduct("Honey");
        int honeyQuantity = 1;
        customer2.addProductToCart(honey,honeyQuantity);

        projectService.run(customer2,productRepo);

        /*
            This customer will have no problems, but the shipment service
            will not have products to ship.
            He is just buying mobile scratch cards
         */

        System.out.println("Customer 3:  \n");
        Customer customer3 = new Customer(
                "ezzat",
                "ezzat@gmail.com",
                100.0,
                new Cart());

        Product mob = productRepo.getProduct("Mobile Scratch Card");
        int mobQuantity = 1;
        customer3.addProductToCart(mob,mobQuantity);

        projectService.run(customer3,productRepo);



        /*
            This customer will have problem, because he does not have sufficient balance
         */

        System.out.println("Customer 4:  \n");
        Customer customer4 = new Customer(
                "akeel",
                "akeel@gmail.com",
                1.0,
                new Cart());

        Product tvP = productRepo.getProduct("TV");
        int tvQuantity = 1;
        customer4.addProductToCart(tvP,tvQuantity);

        projectService.run(customer4,productRepo);





    }
}
