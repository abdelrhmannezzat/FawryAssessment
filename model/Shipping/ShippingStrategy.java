package model.Shipping;

public interface ShippingStrategy {
    Double getShippingCost();
    boolean isShippable();
}
