package cn.xpbootcamp.refactor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class Customer {
    @Getter
    private final String name;

    private List<Rental> rentals = new ArrayList<>();

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String statement() {
        StringBuilder result = new StringBuilder("Rental Record for " + getName() + "：\n");
        result.append(this.rentals.stream().map(Rental::getStatementItem).collect(Collectors.joining()));
        result.append("Amount owed is ").append(getTotalAmount()).append("\n");
        result.append("You earned ").append(getRenterPoints()).append(" frequent renter points");
        return result.toString();
    }

    private BigDecimal getTotalAmount() {
        return this.rentals.stream().map(Rental::getAmountFor).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private int getRenterPoints() {
        return this.rentals.stream().map(Rental::getFrequentRenterPoints).reduce(Integer::sum).get();
    }
}
