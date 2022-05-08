package cn.xpbootcamp.refactor.price;

import java.math.BigDecimal;

public interface RentalPrice {
    BigDecimal getCharge(final int daysRented);
}
