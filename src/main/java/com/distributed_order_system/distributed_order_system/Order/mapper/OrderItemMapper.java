package com.distributed_order_system.distributed_order_system.Order.mapper;

import com.distributed_order_system.distributed_order_system.Order.dto.OrderItemResponse;
import com.distributed_order_system.distributed_order_system.Order.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(source = "product.id", target = "productId")
    OrderItemResponse orderItemToOrderItemResponse(OrderItem orderItem);
}
