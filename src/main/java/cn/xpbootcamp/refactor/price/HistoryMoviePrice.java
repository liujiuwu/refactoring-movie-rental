package cn.xpbootcamp.refactor.price;

import java.math.BigDecimal;

public class HistoryMoviePrice implements RentalPrice {
    @Override
    public BigDecimal getCharge(final int daysRented) {
        BigDecimal charge = new BigDecimal("2");
        if (daysRented > 2) {
            charge = charge.add(new BigDecimal((daysRented - 2) * 1.5));
        }
        return charge.setScale(1);
    }
}
