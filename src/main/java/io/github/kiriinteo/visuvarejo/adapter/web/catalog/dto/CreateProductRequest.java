package io.github.kiriinteo.visuvarejo.adapter.web.catalog.dto;

import java.math.BigDecimal;

public record CreateProductRequest(
        String name,
        BigDecimal price
) {}
