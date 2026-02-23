package io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto;

import io.github.kiriinteo.visuvarejo.core.analytics.ProductRiskResult;

public record ProductRiskResponse(
        String productId,
        double slope,
        double volatility,
        ProductRiskResult.RiskLevel riskLevel
) {}