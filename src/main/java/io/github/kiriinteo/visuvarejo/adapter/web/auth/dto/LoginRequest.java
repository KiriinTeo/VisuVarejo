package io.github.kiriinteo.visuvarejo.adapter.web.auth.dto;

public record LoginRequest(
        String email,
        String password
) {}
