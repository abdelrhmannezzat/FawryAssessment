package model.Expiring;

public class NonExpiringStrategy implements ExpiringStrategy {
    @Override
    public Boolean isExpired() {
        return false;
    }
}
