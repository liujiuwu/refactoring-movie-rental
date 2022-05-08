package cn.xpbootcamp.refactor;

import java.math.BigDecimal;

public class Rental {
    private Movie movie;
    private int daysRented;

    Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    Movie getMovie() {
        return movie;
    }

    BigDecimal getAmountFor() {
        return movie.getAmountFor(daysRented);
    }

    int getFrequentRenterPoints() {
        return movie.getRenterPoints(daysRented);
    }

    public String getStatementItem() {
        return String.format("\t%s\t%s\n", this.movie.getTitle(), this.movie.getAmountFor(daysRented));
    }
}
