package cn.xpbootcamp.refactor;

import cn.xpbootcamp.refactor.price.CampusMoviePrice;
import cn.xpbootcamp.refactor.price.HistoryMoviePrice;
import cn.xpbootcamp.refactor.price.NewReleaseMoviePrice;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public enum MovieType {
    CAMPUS(CampusMoviePrice.class, 1, 0) {
        public BigDecimal getCharge(final int daysRented) {
            BigDecimal charge = new BigDecimal(OVER_TIMES);
            if (daysRented > OVER_DAYS) {
                charge = charge.add(new BigDecimal((daysRented - OVER_DAYS) * OVER_TIMES));
            }
            return charge.setScale(1);
        }
    },
    HISTORY(HistoryMoviePrice.class, 1, 0){
        @Override
        public BigDecimal getCharge(final int daysRented) {
            BigDecimal charge = new BigDecimal("2");
            if (daysRented > 2) {
                charge = charge.add(new BigDecimal((daysRented - 2) * 1.5));
            }
            return charge.setScale(1);
        }
    },
    NEW_RELEASE(NewReleaseMoviePrice.class, 1, 1){
        @Override
        public BigDecimal getCharge(final int daysRented) {
            return new BigDecimal("3").multiply(new BigDecimal(daysRented)).setScale(1);
        }
    };

    public static final double OVER_TIMES = 1.5;
    public static final int OVER_DAYS = 3;
    final Class clazz;

    final int point;

    final int extraPoint;

    public int getRenterPoints(final int daysRented) {
        if (daysRented > 1) {
            return this.getPoint() + this.getExtraPoint();
        }
        return this.getPoint();
    }
    abstract BigDecimal getCharge(final int daysRented);
}
