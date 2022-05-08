package cn.xpbootcamp.refactor.price;

import java.math.BigDecimal;

public class CampusMoviePrice implements RentalPrice {
    @Override
    public BigDecimal getCharge(final int daysRented) {
        BigDecimal charge = new BigDecimal("1.5");
        if (daysRented > 3)
            charge = charge.add(new BigDecimal((daysRented - 3) * 1.5));
        return charge.setScale(1);
    }
}
