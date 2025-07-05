package model;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice(){
        return product.getPrice() * quantity;
    }

    public Double getShippingPrice(){
        if (product.isShippable()){
            return product.getShippingStrategy().getShippingCost() * quantity;
        }
        return 0.0;
    }

    public boolean isShippable(){
        return product.isShippable();
    }

}
