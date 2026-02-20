package io.github.kiriinteo.visuvarejo.adapter.web.auth.dto;

public record RegisterResponse(
        String userId,
        String companyId,
        String email,
        String message
) {}