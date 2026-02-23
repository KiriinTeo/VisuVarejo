package io.github.kiriinteo.visuvarejo.adapter.web.analytics;

import io.github.kiriinteo.visuvarejo.core.domain.Period;
import io.github.kiriinteo.visuvarejo.application.analytics.GetProductRiskAnalysisUseCase;
import io.github.kiriinteo.visuvarejo.application.analytics.GetAverageTicketUseCase;
import io.github.kiriinteo.visuvarejo.application.analytics.GetRevenueByPeriodUseCase;
import io.github.kiriinteo.visuvarejo.application.analytics.GetGrowthScoreUseCase;
import io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto.ProductRiskResponse;
import io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto.RevenueResponse;
import io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto.TicketAverageResponse;
import io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto.GrowthScoreResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final GetRevenueByPeriodUseCase getRevenueByPeriodUseCase;
    private final GetAverageTicketUseCase getAverageTicketUseCase;
    private final GetProductRiskAnalysisUseCase getProductRiskAnalysisUseCase;
    private final GetGrowthScoreUseCase getGrowthScoreUseCase;

    public AnalyticsController(GetRevenueByPeriodUseCase getRevenueByPeriodUseCase, GetAverageTicketUseCase getAverageTicketUseCase, GetProductRiskAnalysisUseCase getProductRiskAnalysisUseCase, GetGrowthScoreUseCase getGrowthScoreUseCase) {
        this.getRevenueByPeriodUseCase = getRevenueByPeriodUseCase;
        this.getAverageTicketUseCase = getAverageTicketUseCase;
        this.getProductRiskAnalysisUseCase = getProductRiskAnalysisUseCase;
        this.getGrowthScoreUseCase = getGrowthScoreUseCase;
    }

    @GetMapping("/revenue")
    public RevenueResponse getRevenue(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {
        BigDecimal totalRevenue = getRevenueByPeriodUseCase.execute(start, end);
        return new RevenueResponse(start, end, totalRevenue);
    }
    
    @GetMapping("/ticket-average")
    public TicketAverageResponse getAverageTicket(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {
        BigDecimal averageTicket = getAverageTicketUseCase.execute(start, end);
        return new TicketAverageResponse(start, end, averageTicket);
    }

    @GetMapping("/products/risk")
    public List<ProductRiskResponse> getProductRisk(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {

        Period period = new Period(start.toLocalDate(), end.toLocalDate());

        return getProductRiskAnalysisUseCase.execute(period)
                .stream()
                .map(r -> new ProductRiskResponse(
                        r.getProductId(),
                        r.getSlope(),
                        r.getVolatility(),
                        r.getRiskLevel()
                ))
                .toList();
    }

    @GetMapping("/products/growth-score")
    public List<GrowthScoreResponse> getGrowthScore(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {

        Period period = new Period(start.toLocalDate(), end.toLocalDate());

        return getGrowthScoreUseCase.execute(period)
                .stream()
                .map(r -> new GrowthScoreResponse(
                        r.getProductId(),
                        r.getGrowthScore(),
                        r.getSlope(),
                        r.getAverageRevenue(),
                        r.getVolatility()
                ))
                .toList();
    }
}
