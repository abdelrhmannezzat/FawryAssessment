package model;

public class Customer {
    private String name;
    private String email;
    private Double balance;
    private Cart cart;
    public Customer(String name, String email, Double balance, Cart cart) {
        this.name = name;
        this.email = email;
        this.balance = balance;
        this.cart = cart;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Cart getCart() {
        return cart;
    }

    public boolean canAfford(Double p){
        return p <= balance;
    }

    public void dedcuteBalance(Double p){
        balance -= p;
    }

    public void addProductToCart(Product product,int quantity) {
        if (quantity > product.getQuantity()) {
            System.out.println("The quantity is not sufficient");
            return;
        }
        this.cart.addProduct(product,quantity);
    }
    public Double getTotalProductsPrice(){
        return cart.getTotalProductsPrice();
    }

    public Double getTotalShippingPrice(){
        return cart.getTotalShippingPrice();
    }

    public void printCheck(){
        cart.printCheck();
    }

}
