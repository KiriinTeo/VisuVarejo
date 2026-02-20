package io.github.kiriinteo.visuvarejo.application.sales;

import io.github.kiriinteo.visuvarejo.core.domain.Period;
import io.github.kiriinteo.visuvarejo.core.domain.Sale;
import io.github.kiriinteo.visuvarejo.core.port.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GetSalesByPeriodUseCase {

    private final SaleRepository saleRepository;

    public GetSalesByPeriodUseCase(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public List<Sale> execute(LocalDateTime start, LocalDateTime end) {

        if (start == null || end == null) {
            throw new IllegalArgumentException("Datas de início e fim são obrigatórias");
        }

        if (end.isBefore(start)) {
            throw new IllegalArgumentException("Data final não pode ser anterior à data inicial");
        }

        Period period = new Period(start.toLocalDate(), end.toLocalDate());
        return saleRepository.findByPeriod(period);
    }
}
