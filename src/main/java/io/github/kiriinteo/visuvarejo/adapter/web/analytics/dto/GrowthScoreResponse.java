package io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto;

public record GrowthScoreResponse(
        String productId,
        double growthScore,
        double slope,
        double averageRevenue,
        double volatility
) {}