package model.Shipping;

public class NonShippingStrategy implements ShippingStrategy{

    @Override
    public Double getShippingCost() {
        return 0.0;
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
