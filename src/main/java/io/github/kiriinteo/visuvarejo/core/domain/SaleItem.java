package io.github.kiriinteo.visuvarejo.core.domain;

import java.util.UUID;

public class SaleItem {

    private final UUID productId;
    private final int quantity;
    private Money unitPrice;

    public SaleItem(UUID productId, int quantity, Money unitPrice) {
        if (productId == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Money getTotal() {
        return unitPrice.multiply(quantity);
    }

    public UUID getProductId() {
        return productId;
    }

    public Money getUnitPrice() { 
        return unitPrice; 
    }

    public int getQuantity() {
        return quantity;
    }
}
