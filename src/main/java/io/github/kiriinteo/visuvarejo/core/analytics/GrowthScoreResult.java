package io.github.kiriinteo.visuvarejo.core.analytics;

public class GrowthScoreResult {

    private final String productId;
    private final double growthScore;
    private final double slope;
    private final double averageRevenue;
    private final double volatility;

    public GrowthScoreResult(String productId,
                             double growthScore,
                             double slope,
                             double averageRevenue,
                             double volatility) {
        this.productId = productId;
        this.growthScore = growthScore;
        this.slope = slope;
        this.averageRevenue = averageRevenue;
        this.volatility = volatility;
    }

    public String getProductId() {
        return productId;
    }

    public double getGrowthScore() {
        return growthScore;
    }

    public double getSlope() {
        return slope;
    }

    public double getAverageRevenue() {
        return averageRevenue;
    }

    public double getVolatility() {
        return volatility;
    }
}