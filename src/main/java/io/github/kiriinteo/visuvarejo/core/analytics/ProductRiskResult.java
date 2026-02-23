package io.github.kiriinteo.visuvarejo.core.analytics;

public class ProductRiskResult {

    private final String productId;
    private final double slope;
    private final double volatility;
    private final RiskLevel riskLevel;

    public ProductRiskResult(String productId,
                             double slope,
                             double volatility,
                             RiskLevel riskLevel) {
        this.productId = productId;
        this.slope = slope;
        this.volatility = volatility;
        this.riskLevel = riskLevel;
    }

    public String getProductId() {
        return productId;
    }

    public double getSlope() {
        return slope;
    }

    public double getVolatility() {
        return volatility;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public enum RiskLevel {
        HEALTHY,
        LOW_RISK,
        MEDIUM_RISK,
        HIGH_RISK
    }
}