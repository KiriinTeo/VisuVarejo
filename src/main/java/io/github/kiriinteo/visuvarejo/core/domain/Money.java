package io.github.kiriinteo.visuvarejo.core.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {

    private final BigDecimal value;

    public Money(BigDecimal value) {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.value = value.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Money multiply(int quantity) {
        return new Money(value.multiply(BigDecimal.valueOf(quantity)));
    }

    public Money add(Money other) {
        return new Money(this.value.add(other.value));
    }
    
    public boolean isGreaterThanZero() {
        return value.compareTo(BigDecimal.ZERO) > 0;
    }
    
}
