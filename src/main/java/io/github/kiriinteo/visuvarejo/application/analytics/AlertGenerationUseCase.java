package io.github.kiriinteo.visuvarejo.application.analytics;

import io.github.kiriinteo.visuvarejo.core.alerts.Alert;
import io.github.kiriinteo.visuvarejo.core.alerts.AlertType;
import io.github.kiriinteo.visuvarejo.core.analytics.ProductRiskResult;
import io.github.kiriinteo.visuvarejo.core.domain.Period;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertGenerationUseCase {

    private final GetProductRiskAnalysisUseCase riskUseCase;
    private final GetTrendAnalysisUseCase trendUseCase;

    public AlertGenerationUseCase(
            GetProductRiskAnalysisUseCase riskUseCase,
            GetTrendAnalysisUseCase trendUseCase
    ) {
        this.riskUseCase = riskUseCase;
        this.trendUseCase = trendUseCase;
    }

    public List<Alert> execute(
            LocalDate previousStart,
            LocalDate previousEnd,
            LocalDate currentStart,
            LocalDate currentEnd
    ) {

        List<Alert> alerts = new ArrayList<>();

        Period currentPeriod = new Period(currentStart, currentEnd);

        List<ProductRiskResult> risks =
                riskUseCase.execute(currentPeriod);

        for (ProductRiskResult risk : risks) {

            if ("CRITICAL".equals(risk.getRiskLevel())) {
                alerts.add(new Alert(
                        AlertType.HIGH_RISK_PRODUCT,
                        "Produto " + risk.getProductId() + " está com risco CRITICO de queda nas vendas"
                ));
            }

            if (risk.getSlope() < 0) {
                alerts.add(new Alert(
                        AlertType.DECLINING_PRODUCT,
                        "Produto " + risk.getProductId() + " está em declínio nas vendas"
                ));
            }
        }

        double trend = trendUseCase.execute(
                previousStart,
                previousEnd,
                currentStart,
                currentEnd
        );

        if (trend < -15) {
            alerts.add(new Alert(
                    AlertType.GLOBAL_DECLINE,
                    "Vendas caíram mais de 15% comparado ao período anterior"
            ));
        }

        if (trend > 40) {
            alerts.add(new Alert(
                    AlertType.ANOMALOUS_GROWTH,
                    "Vendas aumentaram mais de 40% comparado ao período anterior"
            ));
        }

        return alerts;
    }
}