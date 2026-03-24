package com.distributed_order_system.distributed_order_system.Inventory.mapper;

import com.distributed_order_system.distributed_order_system.Inventory.dto.InventoryResponse;
import com.distributed_order_system.distributed_order_system.Inventory.entity.InventoryTransaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(source = "product.id", target = "productId")
    InventoryResponse toResponse(InventoryTransaction transaction);
}
