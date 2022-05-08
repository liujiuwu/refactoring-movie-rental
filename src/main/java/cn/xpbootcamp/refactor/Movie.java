package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.price.RentalPrice;
import lombok.Getter;
import lombok.SneakyThrows;

import java.math.BigDecimal;

public class Movie {
    @Getter
    private final String title;

    @Getter
    private final MovieType movieType;

    private RentalPrice rentalPrice;

    @SneakyThrows
    Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
        this.rentalPrice = (RentalPrice) this.movieType.clazz.newInstance();
    }

    public int getRenterPoints(final int daysRented) {
        return this.movieType.getRenterPoints(daysRented);
    }

    public BigDecimal getAmountFor(final int daysRented) {
        return this.rentalPrice.getCharge(daysRented);
    }
}
