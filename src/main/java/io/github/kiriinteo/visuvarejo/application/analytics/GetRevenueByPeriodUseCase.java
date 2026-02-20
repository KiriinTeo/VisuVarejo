package io.github.kiriinteo.visuvarejo.application.analytics;

import io.github.kiriinteo.visuvarejo.core.domain.Period;
import io.github.kiriinteo.visuvarejo.core.domain.Sale;
import io.github.kiriinteo.visuvarejo.core.port.SaleRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class GetRevenueByPeriodUseCase {

    private final SaleRepository saleRepository;

    public GetRevenueByPeriodUseCase(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public BigDecimal execute(LocalDateTime start, LocalDateTime end) {

        if (start == null || end == null) {
            throw new IllegalArgumentException("Datas de início e fim são obrigatórias");
        }

        if (end.isBefore(start)) {
            throw new IllegalArgumentException("Data final não pode ser anterior à data inicial");
        }

        Period period = new Period(start.toLocalDate(), end.toLocalDate());
        List<Sale> sales = saleRepository.findByPeriod(period);

        return sales.stream()
                .map(sale -> sale.getTotalAmount().getValue())
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
