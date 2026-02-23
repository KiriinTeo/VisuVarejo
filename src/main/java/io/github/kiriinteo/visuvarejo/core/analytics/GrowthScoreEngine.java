package io.github.kiriinteo.visuvarejo.core.analytics;

import java.util.List;

public class GrowthScoreEngine {

    public GrowthScoreResult calculate(String productId,
                                       List<Double> values,
                                       double slope,
                                       double volatility) {

        double mean = values.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);

        double trendScore = normalizeTrend(slope);
        double volumeScore = normalizeVolume(mean);
        double volatilityPenalty = normalizeVolatility(volatility);

        double score =
                (trendScore * 0.5)
                + (volumeScore * 0.3)
                - (volatilityPenalty * 0.2);

        score = Math.max(0, Math.min(100, score));

        return new GrowthScoreResult(
                productId,
                score,
                slope,
                mean,
                volatility
        );
    }

    private double normalizeTrend(double slope) {
        return Math.max(0, Math.min(100, slope * 1000));
    }

    private double normalizeVolume(double mean) {
        return Math.max(0, Math.min(100, mean / 100));
    }

    private double normalizeVolatility(double volatility) {
        return Math.max(0, Math.min(100, volatility / 50));
    }
}