package model.Expiring;

import java.time.LocalDate;

public class DateExpiringStrategy implements ExpiringStrategy {
    private LocalDate expiringDate;

    public DateExpiringStrategy(LocalDate expiringDate) {
        this.expiringDate = expiringDate;
    }

    @Override
    public Boolean isExpired() {
        return null;
    }

    public LocalDate getExpiringDate() {
        return expiringDate;
    }

    public void setExpiringDate(LocalDate expiringDate) {
        this.expiringDate = expiringDate;
    }
}
