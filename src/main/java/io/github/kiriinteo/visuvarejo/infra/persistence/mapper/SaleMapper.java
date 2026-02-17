package io.github.kiriinteo.visuvarejo.infra.persistence.mapper;

import io.github.kiriinteo.visuvarejo.core.domain.*;
import io.github.kiriinteo.visuvarejo.infra.persistence.entity.*;

public class SaleMapper {

    public static SaleEntity toEntity(Sale sale) {

        SaleEntity saleEntity = new SaleEntity(
                sale.getId(),
                sale.getDate()
        );

        sale.getItems().forEach(item -> {
            ProductEntity productEntity = ProductMapper.toEntity(item.getProduct());

            SaleItemEntity itemEntity = new SaleItemEntity(
                    saleEntity,
                    productEntity,
                    item.getQuantity()
            );

            saleEntity.getItems().add(itemEntity);
        });

        return saleEntity;
    }

    public static Sale toDomain(SaleEntity entity) {

        Sale sale = new Sale(entity.getId());

        entity.getItems().forEach(itemEntity -> {

            Product product = ProductMapper.toDomain(itemEntity.getProduct());

            SaleItem item = new SaleItem(
                    product,
                    itemEntity.getQuantity()
            );

            sale.addItem(item);
        });

        return sale;
    }
}
