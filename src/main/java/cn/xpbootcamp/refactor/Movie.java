package cn.xpbootcamp.refactor;

import lombok.Getter;
import lombok.SneakyThrows;

import java.math.BigDecimal;

public class Movie {
    @Getter
    private final String title;

    @Getter
    private final MovieType movieType;

    @SneakyThrows
    Movie(String title, MovieType movieType) {
        this.title = title;
        this.movieType = movieType;
    }

    public int getRenterPoints(final int daysRented) {
        return this.movieType.getRenterPoints(daysRented);
    }

    public BigDecimal getAmountFor(final int daysRented) {
        return this.movieType.getRentalPrice().getCharge(daysRented);
    }
}
