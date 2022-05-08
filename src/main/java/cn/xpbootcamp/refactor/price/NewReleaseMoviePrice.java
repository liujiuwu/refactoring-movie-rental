package cn.xpbootcamp.refactor.price;

import java.math.BigDecimal;

public class NewReleaseMoviePrice implements RentalPrice {
    @Override
    public BigDecimal getCharge(final int daysRented) {
        return new BigDecimal("3").multiply(new BigDecimal(daysRented)).setScale(1);
    }
}
