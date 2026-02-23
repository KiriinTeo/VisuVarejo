package io.github.kiriinteo.visuvarejo.application.config;

import io.github.kiriinteo.visuvarejo.core.analytics.GrowthScoreEngine;
import io.github.kiriinteo.visuvarejo.core.analytics.ProductRiskAnalyzer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnalyticsConfig {

    @Bean
    public ProductRiskAnalyzer productRiskAnalyzer() {
        return new ProductRiskAnalyzer();
    }

    @Bean
    public GrowthScoreEngine growthScoreEngine() {
        return new GrowthScoreEngine();
    }
}