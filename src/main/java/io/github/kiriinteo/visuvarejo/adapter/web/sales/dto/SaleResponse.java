package io.github.kiriinteo.visuvarejo.adapter.web.sales.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record SaleResponse(
        UUID id,
        LocalDateTime date,
        BigDecimal total,
        List<Item> items
) {
    public record Item(
            UUID productId,
            int quantity,
            BigDecimal unitPrice,
            String name
    ) {}
}
