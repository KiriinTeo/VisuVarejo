package io.github.kiriinteo.visuvarejo.core.analytics;

public class TrendAnalyzer {

    public double calculateGrowthRate(double previousValue, double currentValue) {
        if (previousValue == 0) {
            return 0;
        }

        return ((currentValue - previousValue) / previousValue) * 100;
    }
}
