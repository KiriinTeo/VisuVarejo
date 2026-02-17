package io.github.kiriinteo.visuvarejo.infra.persistence.entity;

import jakarta.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    private int quantity;

    protected SaleItemEntity() {}

    public SaleItemEntity(SaleEntity sale,
                          ProductEntity product,
                          int quantity) {
        this.sale = sale;
        this.product = product;
        this.quantity = quantity;
    }

    public UUID getId() { return id; }
    public SaleEntity getSale() { return sale; }
    public ProductEntity getProduct() { return product; }
    public int getQuantity() { return quantity; }
}
