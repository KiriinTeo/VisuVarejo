package io.github.kiriinteo.visuvarejo.adapter.web.analytics.dto;

import java.time.LocalDateTime;

public record MetricsResponse(
        LocalDateTime start,
        LocalDateTime end,
        double totalRevenue,
        int totalItems
) {}