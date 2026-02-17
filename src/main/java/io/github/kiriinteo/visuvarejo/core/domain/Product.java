package io.github.kiriinteo.visuvarejo.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID id;
    private String name;
    private Money price;
    private boolean active;

    public Product(UUID id, String name, Money price) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }

        if (price == null || !price.isGreaterThanZero()) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }

        this.id = id;
        this.name = name;
        this.price = price;
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Money getPrice() {
        return price;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public void updatePrice(Money newPrice) {
        if (newPrice == null || !newPrice.isGreaterThanZero()) {
            throw new IllegalArgumentException("Product price must be greater than zero");
        }
        this.price = newPrice;
    }
}

