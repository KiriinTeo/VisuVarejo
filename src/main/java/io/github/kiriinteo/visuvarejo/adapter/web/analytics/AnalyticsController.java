package io.github.kiriinteo.visuvarejo.adapter.web.analytics;

import io.github.kiriinteo.visuvarejo.application.analytics.GetAverageTicketUseCase;
import io.github.kiriinteo.visuvarejo.application.analytics.GetRevenueByPeriodUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final GetRevenueByPeriodUseCase getRevenueByPeriodUseCase;
    private final GetAverageTicketUseCase getAverageTicketUseCase;

    public AnalyticsController(GetRevenueByPeriodUseCase getRevenueByPeriodUseCase, GetAverageTicketUseCase getAverageTicketUseCase) {
        this.getRevenueByPeriodUseCase = getRevenueByPeriodUseCase;
        this.getAverageTicketUseCase = getAverageTicketUseCase;
    }

    @GetMapping("/revenue")
    public BigDecimal getRevenue(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {
        return getRevenueByPeriodUseCase.execute(start, end);
    }
    
    @GetMapping("/ticket-average")
    public BigDecimal getAverageTicket(
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end
    ) {
        return getAverageTicketUseCase.execute(start, end);
    }
}
