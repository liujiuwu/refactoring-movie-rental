package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.price.CampusMoviePrice;
import cn.xpbootcamp.refactor.price.HistoryMoviePrice;
import cn.xpbootcamp.refactor.price.NewReleaseMoviePrice;
import cn.xpbootcamp.refactor.price.RentalPrice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovieType {
    CAMPUS(CampusMoviePrice.class, 1, 0) {
        RentalPrice getRentalPrice() {
            return new CampusMoviePrice();
        }
    },
    HISTORY(HistoryMoviePrice.class, 1, 0){
        RentalPrice getRentalPrice() {
            return new HistoryMoviePrice();
        }
    },
    NEW_RELEASE(NewReleaseMoviePrice.class, 1, 1){
        RentalPrice getRentalPrice() {
            return new NewReleaseMoviePrice();
        }
    };

    final Class clazz;

    final int point;

    final int extraPoint;

    public int getRenterPoints(final int daysRented) {
        if (daysRented > 1) {
            return this.getPoint() + this.getExtraPoint();
        }
        return this.getPoint();
    }

    abstract RentalPrice getRentalPrice();
}
