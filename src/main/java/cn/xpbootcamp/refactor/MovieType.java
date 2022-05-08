package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.price.CampusMoviePrice;
import cn.xpbootcamp.refactor.price.HistoryMoviePrice;
import cn.xpbootcamp.refactor.price.NewReleaseMoviePrice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MovieType {
    CAMPUS(CampusMoviePrice.class, 1, 0),
    HISTORY(HistoryMoviePrice.class, 1, 0),
    NEW_RELEASE(NewReleaseMoviePrice.class, 1, 1);

    final Class clazz;

    final int point;

    final int extraPoint;

    public int getRenterPoints(final int daysRented) {
        if (daysRented > 1) {
            return this.getPoint() + this.getExtraPoint();
        }
        return this.getPoint();
    }
}
