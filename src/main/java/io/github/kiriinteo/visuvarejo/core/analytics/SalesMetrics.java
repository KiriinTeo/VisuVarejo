package io.github.kiriinteo.visuvarejo.core.analytics;

import io.github.kiriinteo.visuvarejo.core.domain.Money;

public class SalesMetrics {

    private final Money totalRevenue;
    private final int totalItemsSold;
    private final double averageTicket;

    public SalesMetrics(Money totalRevenue, int totalItemsSold) {
        this.totalRevenue = totalRevenue;
        this.totalItemsSold = totalItemsSold;

        this.averageTicket = totalItemsSold == 0
                ? 0
                : totalRevenue.getValue().doubleValue() / totalItemsSold;
    }

    public Money getTotalRevenue() {
        return totalRevenue;
    }

    public int getTotalItemsSold() {
        return totalItemsSold;
    }

    public double getAverageTicket() {
        return averageTicket;
    }
}
