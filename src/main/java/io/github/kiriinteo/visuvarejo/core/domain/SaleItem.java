package io.github.kiriinteo.visuvarejo.core.domain;

public class SaleItem {

    private final Product product;
    private final int quantity;

    public SaleItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public Money getTotal() {
        return product.getPrice().multiply(quantity);
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
