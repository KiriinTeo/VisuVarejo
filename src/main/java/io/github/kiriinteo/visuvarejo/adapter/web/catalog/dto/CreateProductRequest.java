package io.github.kiriinteo.visuvarejo.adapter.web.catalog.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateProductRequest(
        String name,
        BigDecimal price,
        UUID categoryId
) {}
