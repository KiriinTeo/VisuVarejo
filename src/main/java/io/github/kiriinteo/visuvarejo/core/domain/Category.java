package io.github.kiriinteo.visuvarejo.core.domain;

import java.util.UUID;

public class Category {

    private final UUID id;
    private String name;

    public Category(UUID id, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
