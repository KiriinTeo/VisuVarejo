package io.github.kiriinteo.visuvarejo.adapter.web.sales.dto;

import java.util.List;
import java.util.UUID;

public record CreateSaleRequest(
        List<Item> items
) {
    public record Item(
            UUID productId,
            int quantity
    ) {}
}
