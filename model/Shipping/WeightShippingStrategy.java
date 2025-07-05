package model.Shipping;

public class WeightShippingStrategy implements ShippingStrategy{
    private Double weight;

    public WeightShippingStrategy(Double weight) {
        this.weight = weight;
    }

    @Override
    public Double getShippingCost() {
        return weight * 0.5; // 0.5$ for each kilogram
    }

    @Override
    public boolean isShippable() {
        return true;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
