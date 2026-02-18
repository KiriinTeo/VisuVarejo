package io.github.kiriinteo.visuvarejo.infra.persistence.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "sale_items")
public class SaleItemEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "sale_id")
    private SaleEntity sale;

    @Column(name = "product_id", nullable = false)
    private UUID productId;

    private int quantity;
    private BigDecimal unitPrice;

    protected SaleItemEntity() {}

    public SaleItemEntity(SaleEntity sale, UUID productId, int quantity, BigDecimal unitPrice) {
        this.sale = sale;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getId() { return id; }
    public SaleEntity getSale() { return sale; }
    public UUID getProductId() { return productId; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public int getQuantity() { return quantity; }
    
}
